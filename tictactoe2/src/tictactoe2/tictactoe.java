package tictactoe2;

import java.util.*;

public class tictactoe {
	
	static HashSet<Integer> ur_set = new HashSet<Integer>();
	static HashSet<Integer> comp_set = new HashSet<Integer>();
	
	public static void main(String args[]){
		
		char[][] gameboard = {
				{' ','|',' ','|',' '},
				{'-','|','-','|','-'},
				{' ','|',' ','|',' '},
				{'-','|','-','|','-'},
				{' ','|',' ','|',' '},
		};
		print_board(gameboard);
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter Values From 1-9: ");
			int user_pos = in.nextInt();
			while(ur_set.contains(user_pos) || comp_set.contains(user_pos)) {
				System.out.println("Retry with different value!");
				user_pos = in.nextInt();
			}
			place_holder(gameboard, user_pos, "you");
			
			String res = win_conditions();
			
			if(res.length()>0) {
				System.out.println(res);
				break;
			}
			
			
			
			int comp_pos = gen_random();
			while(ur_set.contains(comp_pos) || comp_set.contains(comp_pos)) {
				comp_pos = gen_random();
			}
			place_holder(gameboard, comp_pos, "comp");
			
			res = win_conditions();
			
			if(res.length()>0) {
				System.out.println(res);
				break;
			}
			
	
		}
		in.close();
		
	}
	
	static String win_conditions() {
		HashSet<Integer> r1 = new HashSet<Integer>();
		r1.add(1);r1.add(2);r1.add(3);
		HashSet<Integer> r2 = new HashSet<Integer>();
		r2.add(4);r2.add(5);r2.add(6);
		HashSet<Integer> r3 = new HashSet<Integer>();
		r3.add(7);r3.add(8);r3.add(9);
		HashSet<Integer> d1 = new HashSet<Integer>();
		d1.add(1);d1.add(5);d1.add(9);
		HashSet<Integer> d2 = new HashSet<Integer>();
		d2.add(3);d2.add(5);d2.add(7);
		HashSet<Integer> h1 = new HashSet<Integer>();
		h1.add(1);h1.add(4);h1.add(7);
		HashSet<Integer> h2 = new HashSet<Integer>();
		h2.add(2);h2.add(5);h2.add(8);
		HashSet<Integer> h3 = new HashSet<Integer>();
		h3.add(3);h3.add(6);h3.add(9);
		
		
		HashSet<HashSet<Integer>> winner = new HashSet<HashSet<Integer>>();
		
		winner.add(r1); winner.add(r2); winner.add(r3);
		winner.add(h1); winner.add(h2); winner.add(h3);
		winner.add(d1); winner.add(d2);		
		
		for(HashSet<Integer> c:winner){
			if(ur_set.containsAll(c)) {
				return "congrats you won!!";
			}
			
			if(comp_set.containsAll(c)) {
				return "Sorry, you lose, try again!";
			}
			
			if(ur_set.size()+comp_set.size()==9) {
				return "It's a draw";
			}
			
		}
		
		return "";
		
	}
	
	
	static void print_board(char[][] gameboard) {
		for(int i = 0; i < gameboard.length; i++){
			for(int j = 0; j < gameboard[0].length; j++) {
				System.out.print(gameboard[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	static int gen_random() {
		int max = 9;
		int min = 1;
		int range = max - min + 1;
		int res = (int) (Math.random() * range) + min;
		return res;
	}
	
	static void place_holder(char[][] gameboard, int pos, String user) {
		char syb = 'X';
		
		if(user.equals("you")) {
			syb = 'X';
			ur_set.add(pos);
		} else if(user.equals("comp")) {
			syb = 'O';
			comp_set.add(pos);
		}
		
		switch(pos) {
			case 1:
				gameboard[0][0] = syb;
				break;
			case 2:
				gameboard[0][2] = syb;
				break;
			case 3:
				gameboard[0][4] = syb;
				break;
			case 4:
				gameboard[2][0] = syb;
				break;
			case 5:
				gameboard[2][2] = syb;
				break;
			case 6:
				gameboard[2][4] = syb;
				break;
			case 7:
				gameboard[4][0] = syb;
				break;
			case 8:
				gameboard[4][2] = syb;
				break;
			case 9:
				gameboard[4][4] = syb;
				break;
			default:
				System.out.println("Invalid position! Try again.");
		}
		
		print_board(gameboard);
	}
}
