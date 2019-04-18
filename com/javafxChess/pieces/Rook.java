package com.javafxChess.pieces;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import com.javafxChess.board.MoveLog;

public class Rook extends Piece{

	/**
	*Initializes rook with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Rook(boolean team, int[] location, ImageView pic, GridPane pane) {
		super(team, location, pic, pane);
		this.setName("Rook");
	}


	public boolean moveValid(int[] loc, Piece[][] board) {
		if(pathClear(loc, board)) {
			if(super.getX()==loc[0]){ //Vertical
				return true;
			} else if(super.getY()==loc[1]){ //Horizontal
				return true;
			}
		}
		return false;
	}
}
