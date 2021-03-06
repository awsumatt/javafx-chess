package com.javafxChess.board;

import javafx.scene.layout.GridPane;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;
import com.javafxChess.pieces.*;




public class Board{

		public static Piece[][] makeBoard(){
			return new Piece[8][8];
		}
		/**
		*Creates a piece array with new piece objects
		*
		*@param ImageView The image associated with each piece
		*/
		public static void initializeBoard(Piece[][] board, GridPane pane, ImageView kingB, ImageView queenB, ImageView bishopB1, ImageView bishopB2, ImageView knightB1, ImageView knightB2, ImageView rookB1, ImageView rookB2, ImageView pawnB1, ImageView pawnB2, ImageView pawnB3, ImageView pawnB4, ImageView pawnB5, ImageView pawnB6, ImageView pawnB7, ImageView pawnB8, ImageView kingW, ImageView queenW, ImageView bishopW1, ImageView bishopW2, ImageView knightW1, ImageView knightW2, ImageView rookW1, ImageView rookW2, ImageView pawnW1, ImageView pawnW2, ImageView pawnW3, ImageView pawnW4, ImageView pawnW5, ImageView pawnW6, ImageView pawnW7, ImageView pawnW8){
			//////////////
			//Black Team//
			//////////////
			ImageView[] bPawns = new ImageView[]{pawnB1, pawnB2, pawnB3, pawnB4, pawnB5, pawnB6, pawnB7, pawnB8};
			board[0][0] = new Rook(false, new int[]{0, 0}, rookB1, pane);
			board[7][0] = new Rook(false, new int[]{7, 0}, rookB2, pane);
			board[1][0] = new Knight(false, new int[]{1, 0}, knightB1, pane);
			board[6][0] = new Knight(false, new int[]{6, 0}, knightB2, pane);
			board[2][0] = new Bishop(false, new int[]{2, 0}, bishopB1, pane);
			board[5][0] = new Bishop(false, new int[]{5, 0}, bishopB2, pane);
			board[3][0] = new Queen(false, queenB, pane);
			board[4][0] = new King(false, queenB, pane);
			for (int i=0; i<8; i++) { //Pawn loop
				board[i][1] = new Pawn(false, new int[]{i, 1}, bPawns[i], pane);
			}

			//////////////
			//White Team//
			//////////////
			ImageView[] wPawns = new ImageView[]{pawnW1, pawnW2, pawnW3, pawnW4, pawnW5, pawnW6, pawnW7, pawnW8};
			board[0][7] = new Rook(true, new int[]{0, 7}, rookW1, pane);
			board[7][7] = new Rook(true, new int[]{7, 7}, rookW2, pane);
			board[1][7] = new Knight(true, new int[]{1, 7}, knightW1, pane);
			board[6][7] = new Knight(true, new int[]{6, 7}, knightW2, pane);
			board[2][7] = new Bishop(true, new int[]{2, 7}, bishopW1, pane);
			board[5][7] = new Bishop(true, new int[]{5, 7}, bishopW2, pane);
			board[3][7] = new Queen(true, queenW, pane);
			board[4][7] = new King(true, kingW, pane);
			for (int i=0; i<8; i++) { //Pawn loop
				board[i][6] = new Pawn(true, new int[]{i, 6}, wPawns[i], pane);
			}
		}
}
