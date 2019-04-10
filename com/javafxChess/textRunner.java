
package com.javafxChess;

import java.io.FileNotFoundException;
import java.util.Scanner;
import com.javafxChess.pieces.*;
import com.javafxChess.board.Board;
import com.javafxChess.board.MoveLog;


public class textRunner {
	public static void main(String[] args) throws FileNotFoundException {
		Piece[][] b = Board.makeBoard();
		Board.initializeBoard(b);
		MoveLog log = new MoveLog();
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int[] s = new int[2];
		int[] e = new int[2];
		boolean team = true;
		while(team) {
			System.out.print("Enter start position (x \"enter\" y): ");
			s[0] = in.nextInt();
			s[1] = in.nextInt();

			System.out.print("Enter end position (x \"enter\" y): ");
			e[0] = in.nextInt();
			e[1] = in.nextInt();
			if(team == b[s[0]][s[1]].getTeam() && b[s[0]][s[1]].move(e, b, log)) {
				System.out.println("Valid move");
				team = !team;
			} else {
				System.out.println("Invalid move, try again");
			}
		}
		log.close();
	}
}
