package com.javafxChess.pieces;

public class Rook extends Piece{
	private Boolean canCastle;
	private String side;
	Rook(int[][] loc, String side) {
		super(loc);
		canCastle = true;
		this.side = side;
	}
	
	public Boolean move(int[] loc) {
		if(super.getX() == loc[0] && super.getY() != loc[1]) {;
			super.location[1] = loc[1];
			canCastle = false;
			return true;
		} else if(super.getX() != loc[0] && super.getY() == loc[1]) {
			super.location[0] = loc[0];;
			canCastle = false;
			return true;
		}
		return false;
	}
	
	public Boolean getCanCastle() {
		return canCastle;
	}
	
	public String getSide() {
		return side;
	}
}
