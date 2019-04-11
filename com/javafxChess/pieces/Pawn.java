package com.javafxChess.pieces;

import javafx.scene.image.ImageView;
import com.javafxChess.board.MoveLog;

public class Pawn extends Piece{
	private boolean firstMove = true;

	/**
	*Initializes pawn with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Pawn(boolean team, int[] location, ImageView pic){
		super(team, location, pic);
		this.setName("Pawn");
	}

	@Override
	public boolean move(int[] loc, Piece[][] board, MoveLog log){
		if(moveValid(loc, board)) {
			location = loc;
			firstMove = false;
			return true;
		}
		return false;
	}

	@Override
	public boolean moveValid(int[] loc, Piece[][] board) {
		if(firstMove) {
			if(loc[0] == location[0] && loc[1] == location[1] + 2 && board[loc[0]][loc[1]] == null) {
				return true;
			}
		}
		if((loc[0] == location[0] && loc[1] == location[1] + 1 && board[loc[0]][loc[1]] == null) ||
		  ((loc[0] == location[0] + 1 || loc[0] == location[0] - 1) && loc[1] == location[1] + 1) && spaceClear(loc, board)) {
			return true;
		}
		return false;
	}
}
