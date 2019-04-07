package com.javafxChess.pieces;

import java.util.ArrayList;

public class Rook extends Piece{
	private Boolean canCastle;

	/**
	*Initializes rook with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Rook(boolean team, int[] location) {
		super(team, location);
		this.setName("Rook");
		canCastle = true;
	}

	/**
	 * @param loc Location to move the piece
	 * @param board The board the piece is on
	 *
	 * @return True if the move is valid, false otherwise
	 */
	@Override
	public boolean move(int[] loc, Piece[][] board) {
		if(canMove(loc, board)) {
			location = loc;
			canCastle = false;
			return true;
		}
		return false;
	}

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

	public Boolean getCanCastle() {
		return canCastle;
	}

	public char getSide() {
		if(location[0] < 5) {
			return 'q';
		}
		return 'k';
	}
	//TODO Sorry, changed the implementation on ya, I tried to make sure you hadn't changed anything before I oficially switched it but you pushed after i changed everything
	private boolean canMove(int[] loc, Piece[][] board) {
		if(getX() == loc[0] && getY() != loc[1] && moveValid(loc, board)) {;
			return true;
		} else if(getX() != loc[0] && getY() == loc[1] && moveValid(loc, board)) {
			return true;
		}
		return false;
	}
}
