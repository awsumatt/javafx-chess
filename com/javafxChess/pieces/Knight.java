package com.javafxChess.pieces;
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
	}

	@Override //Needs different move validation because of ability to jump pieces
	public boolean moveValid(int[] loc, Piece[][] board){
		if(board[loc[0]][loc[1]].getTeam() != super.getTeam() || board[loc[0]][loc[1]] == null){
			return true;
		}
		return false;
	}

	// Move length calculators for move validation
	private int yLength(int[] loc){
		return Math.abs(this.getY()-loc[1]);
	}

	private int xLength(int[] loc){
		return Math.abs(this.getX() - loc[0]);
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
			if((xLength(loc)==1 && yLength(loc)==2) || (xLength(loc)==2 && yLength(loc)==1)){
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
