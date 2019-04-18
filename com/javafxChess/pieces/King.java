package com.javafxChess.pieces;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import com.javafxChess.board.MoveLog;
import java.lang.Math;

public class King extends Piece{
	private Boolean canCastle = true;
	/**
	*Initializes king with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*@param log Logger that the move will be stored in
	*/
	public King(boolean team, int[] location, MoveLog log, ImageView pic, GridPane pane){
		super(team, location, pic, pane);
		this.setName("King");
	}

	/**
	*Initializes king with the default location
	*
	*@param team true=white team, false=black team
	*/
	public King(boolean team, ImageView pic, GridPane pane){
		super(team, pic, pane);
		if(team){ //White team default location
			location[0] = 4;
			location[1] = 7;
		} else { //Black team default location
			location[0] = 4;
			location[1] = 0;
		}

	}

	public boolean possCheck(int[] loc, Piece[][] board){
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if(board[i][j] instanceof Piece){
					if(board[i][j].moveValid(loc, board)){
						return true;
					}
				}
			}
		}
		return false;
	}

	//Move length calculators
	private int yLength(int[] loc){
		return Math.abs(this.getY()-loc[1]);
	}

	private int xLength(int[] loc){
		return Math.abs(this.getX() - loc[0]);
	}

	@Override
	public boolean moveValid(int[] loc, Piece[][] board) {
		if(!possCheck(loc, board)){
			if(pathClear(loc, board) && xLength(loc)+yLength(loc)<=2){
				return true;
			}
		}
		return false;
	}
}
