package com.javafxChess.pieces;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import com.javafxChess.board.MoveLog;
import java.lang.Math;

public class Queen extends Piece{

	/**
	*Initializes queen with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Queen(boolean team, int[] location, ImageView pic, GridPane pane){
		super(team, location, pic, pane);
		this.setName("Queen");
	}

	/**
	*Initializes queen with the default location
	*
	*@param team true=white team, false=black team
	*/
	public Queen(boolean team, ImageView pic, GridPane pane){
		super(team, pic, pane);
		if(team){ //White team default location
			location[0] = 3;
			location[1] = 7;
		} else { //Black team default location
			location[0] = 3;
			location[1] = 0;
		}

	}


	@Override
	public boolean moveValid(int[] loc, Piece[][] board){
		if(pathBlocked(loc, board)){
			if(super.getX()==loc[0]){ //Vertical
				return true;
			} else if(super.getY()==loc[1]){ //Horizontal
				return true;
			} else if(Math.abs(loc[0]-super.getX())==Math.abs(loc[1]-super.getY())){ //Diagonal
				return true;
			}
		}

		return false;
	}


}
