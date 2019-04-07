package com.javafxChess.pieces;


public class King extends Piece{

	/**
	*Initializes king with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*@param log Logger that the move will be stored in
	*/
	public King(boolean team, int[] location, MoveLog log){
		super(team, location);
		this.setName("King");
	}

	/**
	*Initializes king with the default location
	*
	*@param team true=white team, false=black team
	*/
	public King(boolean team){
		super(team);
		if(team){ //White team default location
			location[0] = 4;
			location[1] = 7;
		} else { //Black team default location
			location[0] = 4;
			location[1] = 0;
		}

	}

	/**
	*@return True if move valid, false otherwise
	*/
	public boolean move(int[][] board){

		 return false;
	}

}
