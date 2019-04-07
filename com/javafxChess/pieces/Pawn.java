package com.javafxChess.pieces;

import java.util.ArrayList;

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
	public boolean move(int[] loc, Piece[][] board) {
		if(canMove(loc, board)) {
			location = loc;
			firstMove = false;
			return true;
		}
		return false;
	}

	@Override
	public int[][] getPosMoves(Piece[][] board) {
		ArrayList<int[]> moves = new ArrayList<>();
		for(int i = 0; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				int[] e = {i, j};
				if(canMove(e, board)) {
					moves.add(e);
				}
			}
		}
		return (int[][]) moves.toArray();
	}
	
	private boolean canMove(int[] loc, Piece[][] board) {
		if(firstMove) {
			if(loc[0] == location[0] && loc[1] == location[1] + 2) {
				return true;
			}
		}
		if((loc[0] == location[0] && loc[1] == location[1] + 1) ||
		  ((loc[0] == location[0] + 1 || loc[0] == location[0] - 1) && loc[1] == location[1] + 1) && board[loc[0]][loc[1]] != null) {
			return true;
		}
		return false;
	}
}
