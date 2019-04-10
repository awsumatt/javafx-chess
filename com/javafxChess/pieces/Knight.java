package com.javafxChess.pieces;

import com.javafxChess.board.MoveLog;
import java.lang.Math;


public class Knight extends Piece{

	/**
	*Initializes knight with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Knight(boolean team, int[] location){
		super(team, location);
		this.setName("Knight");
	}

	// Move length calculators for Knight move validation
	private int yLength(int[] loc){
		return Math.abs(this.getY()-loc[1]);
	}

	private int xLength(int[] loc){
		return Math.abs(this.getX() - loc[0]);
	}


	@Override
	public boolean move(int[] loc, Piece[][] board, MoveLog log){
		if(moveValid(loc, board)){
			board[this.getX()][this.getY()]=null;
			log.moveToString(this, location, loc);
			location=loc;
			ifEnemyRemove(loc, board, log);
			board[this.getX()][this.getY()]=this;
			return true;
		}
		return false;
	}

	@Override
	public boolean moveValid(int[] loc, Piece[][] board){
		if(spaceClear(loc, board)){
			if((xLength(loc)==1 && yLength(loc)==2) || (xLength(loc)==2 && yLength(loc)==1)){
				return true;
			}
		}
		return false;
	}

}
