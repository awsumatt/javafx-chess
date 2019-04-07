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
	public boolean move(int[] loc, Piece[][] board){
		if(moveValid(loc, board)){
			if(super.getX()==loc[0]){ //Vertical
				board[this.getX()][this.getY()]=null;
				location=loc;
				ifEnemyRemove(loc, board);
				board[this.getX()][this.getY()]=this;
				return true;
			} else if(super.getY()==loc[1]){ //Horizontal
				board[this.getX()][this.getY()]=null;
				location=loc;
				ifEnemyRemove(loc, board);
				board[this.getX()][this.getY()]=this;
				return true;
			} else if(Math.abs(loc[0]-super.getX())==Mathh.abs(loc[1]-super.getY())){ //Diagonal
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
