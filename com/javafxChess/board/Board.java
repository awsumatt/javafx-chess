package com.javafxChess.board;

import com.javafxChess.pieces.*;



//This class might be temporary, we might merge it into the main program
public class Board{

		public static Piece[][] makeBoard(){
			return new Piece[8][8];
		}

		public static void initializeBoard(Piece[][] board){
			//Black Team
			board[0][0] = new Rook(false, new int[]{0, 0});
			board[7][0] = new Rook(false, new int[]{7, 0});
			board[1][0] = new Knight(false, new int[]{1, 0});
			board[6][0] = new Knight(false, new int[]{6, 0});
			board[2][0] = new Bishop(false, new int[]{2, 0});
			board[5][0] = new Bishop(false, new int[]{5, 0});
			board[3][0] = new Queen(false);
			board[4][0] = new King(false);
			for (int i=0; i<8; i++) { //Pawn loop
				board[i][1] = new Pawn(false, new int[]{i, 1});
			}

			//White Team
			board[0][7] = new Rook(true, new int[]{0, 7});
			board[7][7] = new Rook(true, new int[]{7, 7});
			board[1][7] = new Knight(true, new int[]{1, 7});
			board[6][7] = new Knight(true, new int[]{6, 7});
			board[2][7] = new Bishop(true, new int[]{2, 7});
			board[5][7] = new Bishop(true, new int[]{5, 7});
			board[3][7] = new Queen(true);
			board[4][7] = new King(true);
			for (int i=0; i<8; i++) { //Pawn loop
				board[i][6] = new Pawn(true, new int[]{i, 6});
			}
		}
}
