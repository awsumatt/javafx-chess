package com.javafxChess.pieces;


public class Queen extends Piece{

	/**
	*Initializes queen with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Queen(boolean team, int[] location){
		super(team, location);
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
	*
	*@return True if move valid, false otherwise
	*/
	@Override
	public Boolean move(int[] loc, Piece[][] board){
		if(super.getX()==loc[0] && (board[loc[0]][loc[1]].getTeam()!=super.getTeam() || board[loc[0]][loc[1]] == null)){ //Vertical
			location=loc;
			return true;
		} else if(super.getY()==loc[1]){ //Horizontal
			location = loc;
			return true;
		}
		return false;
	}



}
