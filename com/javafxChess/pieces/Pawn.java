package com.javafxChess.pieces;

import com.javafxChess.board.MoveLog;

public class Pawn extends Piece{
	private boolean firstMove = true;

	/**
	*Initializes pawn with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Pawn(boolean team, int[] location){
		super(team, location);
		this.setName("Pawn");
	}

	@Override
	public boolean move(int[] loc, Piece[][] board, MoveLog log) {
		if(moveValid(loc, board)) {
			board[this.getX()][this.getY()] = null;
			log.moveToString(this, location, loc);
			location = loc;
			ifEnemyRemove(loc, board, log);
			board[this.getX()][this.getY()] = this;
			firstMove = false;
			return true;
		}
		return false;
	}
	
	public boolean moveValid(int[] loc, Piece[][] board) {
		int dir;
		if(this.getTeam()) {
			dir = 1;
		} else {
			dir = -1;
		}
		if(firstMove) {
			if(loc[0] == location[0] && loc[1] == location[1] + 2 * dir) {
				return true;
			}
		}
		if((loc[0] == location[0] && loc[1] == location[1] + dir) ||
		  ((loc[0] == location[0] + 1 || loc[0] == location[0] - 1) && loc[1] == location[1] + dir &&
		  board[loc[0]][loc[1]] != null && board[loc[0]][loc[1]].getTeam() != this.getTeam())) {
			return true;
		}
		return false;
	}
}
