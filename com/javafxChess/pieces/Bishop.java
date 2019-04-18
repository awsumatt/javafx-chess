package com.javafxChess.pieces;

import javafx.scene.layout.GridPane;
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
	public Bishop(boolean team, int[] location, ImageView pic, GridPane pane){
		super(team, location, pic, pane);
		this.setName("Bishop");
	}

	@Override
	public boolean moveValid(int[] loc, Piece[][] board){
		if(pathClear(loc, board)){
			if(Math.abs(loc[0]-super.getX())==Math.abs(loc[1]-super.getY())){ //Diagonal
				return true;
			}
		}

		return false;
	}


}
