package com.javafxChess.pieces;

import java.lang.Math;

public class Queen extends Piece{

	/**
	*Initializes queen with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Queen(boolean team, int[] location){
		super(team, location);
		this.setName("Queen");
	}

	/**
	*Initializes queen with the default location
	*
	*@param team true=white team, false=black team
	*/
	public Queen(boolean team){
		super(team);
		if(team){ //White team default location
			location[0] = 3;
			location[1] = 7;
		} else { //Black team default location
			location[0] = 3;
			location[1] = 0;
		}

	}


	/**
	*@param loc Location player wants to move the piece
	*@param board The board
	*@param log Logger that the move will be stored in
	*
	*@return True if move valid, false otherwise
	*/
	@Override
	public boolean move(int[] loc, Piece[][] board, MoveLog log){
		if(moveValid(loc, board)){
			if(canMove(loc, board)){
				board[this.getX()][this.getY()]=null;
				log.moveToString(this, location, loc);
				location=loc;
				ifEnemyRemove(loc, board, log);
				board[this.getX()][this.getY()]=this;
				return true;
			}
		}
		return false;
	}


	@Override
	public boolean canMove(int[] loc, Piece[][] board){
		if(moveValid(loc, board)){
			if(super.getX()==loc[0]){ //Vertical
				return true;
			} else if(super.getY()==loc[1]){ //Horizontal
				return true;
			} else if(Math.abs(loc[0]-super.getX())==Math.abs(loc[1]-super.getY())){ //Diagonal
				return true;
			}
		}
		return false;
	}


}
