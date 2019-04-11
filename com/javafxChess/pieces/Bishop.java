package com.javafxChess.pieces;

import javafx.scene.image.ImageView;
import com.javafxChess.board.MoveLog;
import java.lang.Math;


public class Bishop extends Piece{

	/**
	*Initializes bishop with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Bishop(boolean team, int[] location, ImageView pic){
		super(team, location, pic);
		this.setName("Bishop");
	}


	@Override
	public boolean move(int[] loc, Piece[][] board, MoveLog log){
		if(moveValid(loc, board)){
			board[this.getX()][this.getY()]=null;
			log.moveToString(this, location, loc);
			location=loc;
			ifEnemyRemove(loc, board, log);
			board[this.getX()][this.getY()]=this;
			return true;

		}
		return false;
	}

	@Override
	public boolean moveValid(int[] loc, Piece[][] board){
		if(pathBlocked(loc, board)){
			if(Math.abs(loc[0]-super.getX())==Math.abs(loc[1]-super.getY())){ //Diagonal
				return true;
			}
		}

		return false;
	}


}
