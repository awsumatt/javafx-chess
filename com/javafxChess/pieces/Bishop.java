package com.javafxChess.pieces;


public class Bishop extends Piece{

	/**
	*Initializes queen with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Bishop(boolean team, int[] location){
		super(team, location);
	}


	/**
	*@param loc Location player wants to move the piece
	*@param board The board
	*
	*@return True if move valid, false otherwise
	*/
	@Override
	public boolean move(int[] loc, Piece[][] board){
		if(moveValid(loc, board)){
			if(loc[0]-super.getX()==loc[1]-super.getY()){ //Diagonal
				board[this.getX()][this.getY()]=null;
				location=loc;
				ifEnemyRemove(loc, board);
				board[this.getX()][this.getY()]=this;
				return true;
			}
		}
		return false;
	}



}
