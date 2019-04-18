package com.javafxChess.pieces;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import com.javafxChess.board.MoveLog;
import java.lang.Math;

public class Pawn extends Piece{
	private boolean firstMove = true;

	/**
	*Initializes pawn with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Pawn(boolean team, int[] location, ImageView pic, GridPane pane){
		super(team, location, pic, pane);
		this.setName("Pawn");
	}

	/** Checks if space is empty */
	@Override
	public boolean spaceClear(int[] loc, Piece[][] board) {
		if(board[loc[0]][loc[1]] == null){ //Space empty
			return true;
		}
		return false;
	}

	@Override
	public boolean move(int[] loc, Piece[][] board, MoveLog log) {
		if(super.move(loc, board, log)){
			firstMove=false;
			return true;
		} else {
			return false;
		}
	}

	/** Checks if pawn is moving forward */
	private boolean moveForward(int[] loc, Piece[][] board){
		if(!this.getTeam() && firstMove && (loc[1]-this.getY()==2 || loc[1]-this.getY()==1) && pathClear(loc, board)){
			return true;
		} else if(this.getTeam() && firstMove && (this.getY()-loc[1]==2 || this.getY()-loc[1]==1) && pathClear(loc, board)){
			return true;
		} else if(!this.getTeam() && loc[1]-this.getY()==1){
			return true;
		} else if(this.getTeam() && this.getY()-loc[1]==1){
			return true;
		}
		return false;
	}

	@Override
	public boolean moveValid(int[] loc, Piece[][] board) {
		if(moveForward(loc, board) && spaceClear(loc, board) && this.getX()==loc[0]){
			return true;
		} else if(!spaceClear(loc, board) && moveForward(loc, board) && Math.abs(loc[0]-super.getX())==Math.abs(loc[1]-super.getY())){
			return true;
		}
		return false;
	}
}
