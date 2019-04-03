package com.javafxChess.pieces;



public abstract class Piece{

/** Location of a piece [x][y] */
private int[] location = new int[2];
/** true=white team, false=black team */
private boolean team;
/** Whether or not a piece has been capture by the opposing team */
private boolean inPlay;
/** Whether or not a piece is putting a king in check */
private boolean check;

public Piece(boolean team, int[] location){
	this.team = team;
	this.location = location;
	inPlay = true;
	check = false;
}

public boolean getTeam(){
	return team;
}

public int[] getLoc(){
	return location;
}

public int getX(){
	return location[0];
}

public int getY(){
	return location[1];
}

public Boolean inplay(){
	return inPlay;
}


public abstract Boolean move();

public abstract int[][] getPosMoves();

}