package com.javafxChess.pieces;

public class Pawn extends Piece{


	/**
	*Initializes pawn with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Pawn(boolean team, int[] location){
		super(team, location);
	}


}
