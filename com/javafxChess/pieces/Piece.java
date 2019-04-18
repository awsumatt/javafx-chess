package com.javafxChess.pieces;

import com.javafxChess.board.MoveLog;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public abstract class Piece{

	/** Location of a piece {x, y} */
	protected int[] location = new int[2];
	/** true=white team, false=black team */
	final private boolean team;
	/** Whether or not a piece has been capture by the opposing team */
	private boolean inPlay;
	/** Whether or not a piece is putting a king in check */
	private boolean check;
	/** Name for move log */
	private String name;
	/** Image of the piece */
	private ImageView pic;
	/** GridPane of the chess board */
	private GridPane pane;

	/**
	*Initializes a piece with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Piece(boolean team, int[] location, ImageView pic, GridPane pane){
		this.team = team;
		this.location = location;
		this.pic = pic;
		this.pane = pane;
		inPlay = true;
		check = false;
		this.pic.managedProperty().bind(this.pic.visibleProperty());
	}

	/**
	*Initializes a piece in its default location
	*
	*@param team true=white team, false=black team
	*/
	public Piece(boolean team, ImageView pic, GridPane pane){
		this.team = team;
		this.pic = pic;
		this.pane = pane;
		inPlay = true;
		check = false;
		this.pic.managedProperty().bind(this.pic.visibleProperty());
	}

	public boolean getTeam(){
		return team;
	}

	public int[] getLoc(){
		return location;
	}

	public int getX(){
		return location[0];
	}

	public int getY(){
		return location[1];
	}

	public GridPane getPane(){
		return pane;
	}

	public ImageView getPic(){
		return pic;
	}

	public boolean inplay(){
		return inPlay;
	}

	public void remove(){
		inPlay = false;
		this.pic.setVisible(false);
	}

	public void setName(String name){
		this.name = name;
	}

	@Override
	public String toString(){
		return name;
	}

	/** Checks if space is occupied by a friendly piece */
	public boolean spaceClear(int[] loc, Piece[][] board){
		if(board[loc[0]][loc[1]] == null){ //Space empty
			return true;
		}
		if (board[loc[0]][loc[1]].getTeam() != this.getTeam()) { //Space enemy
			return true;
		}
		return false;
	}

	/** Takes a piece out of play if a piece moves into its place */
	public void ifEnemyRemove(int[] loc, Piece[][] board, MoveLog log){
		if(board[loc[0]][loc[1]]!=null){
			if(board[loc[0]][loc[1]].getTeam() != team){
				board[loc[0]][loc[1]].remove(); //Takes piece out of play
				log.captureToString(this, board[loc[0]][loc[1]]);//Logs the capture
				board[loc[0]][loc[1]]=null;
			}
		}
	}

	/**
	*Checks move path to see if there are other pieces in the way
	*
	*@param loc Location player wants to move the piece
	*@param board The board
	*
	*@return false if path blocked, true if path clear
	*/
	public boolean pathClear(int[] loc, Piece[][] board){
		int xStart;
		int xEnd;
		int yStart;
		int yEnd;

		if(spaceClear(loc, board)){

			//If-Else block determines where to start the for loop along the move path
			if(loc[0]<this.getX()){
				xStart = loc[0]+1;
				xEnd = this.getX();
			} else{
				xStart = this.getX()+1;
				xEnd = loc[0];
			}

			if(loc[1]<this.getY()){
				yStart = loc[1]+1;
				yEnd = this.getY();
			} else{
				yStart = this.getY()+1;
				yEnd = loc[1];
			}

			//Checks if there are pieces blocking the move path
			for (int i=xStart; i<xEnd; i++) {
				for (int j=yStart; j<yEnd; j++) {
					if(board[i][j] instanceof Piece){
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	*Moves piece, logs move, removes enemy if necessary
	*
	*@param loc Location player wants to move the piece
	*@param board The board
	*@param log Logger that the move will be stored in
	*
	*@return True if move valid, false otherwise
	*/
	public boolean move(int[] loc, Piece[][] board, MoveLog log){
		if(moveValid(loc, board)){
			board[this.getX()][this.getY()]=null;
			log.moveToString(this, location, loc);
			location=loc;
			ifEnemyRemove(loc, board, log);
			board[this.getX()][this.getY()]=this;
			GridPane.setColumnIndex(this.getPic(), loc[0]);
			GridPane.setRowIndex(this.getPic(), loc[1]);
			return true;

		}
		log.moveInv(this);
		return false;
	}

	/**
	*Checks if a move can be made
	*
	*@param loc Location player wants to move the piece
	*@param board The board
	*
	*@return True if move possible, false otherwise
	*/
	public abstract boolean moveValid(int[] loc, Piece[][] board);
}
