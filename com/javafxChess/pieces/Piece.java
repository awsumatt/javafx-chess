package com.javafxChess.pieces;

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

	/**
	*Initializes a piece with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Piece(boolean team, int[] location){
		this.team = team;
		this.location = location;
		inPlay = true;
		check = false;
	}

	/**
	*Initializes a piece in its default location
	*
	*@param team true=white team, false=black team
	*/
	public Piece(boolean team){
		this.team = team;
		inPlay = true;
		check = false;
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

	public boolean inplay(){
		return inPlay;
	}

	public void remove(){
		inPlay = false;
	}

	public void setName(Sting name){
		this.name = name;
	}

	@Override
	public String toString(){
		return name;
	}

	/** Takes a piece out of play if a piece moves into its place */
	public void ifEnemyRemove(int[] loc, Piece[][] board, MoveLog log){
		if(board[loc[0]][loc[1]].getTeam() != team){
			board[loc[0]][loc[1]].remove(); //Takes piece out of play
			log.captureToString(this, board[loc[0]][loc[1]]);//Logs the capture
			board[loc[0]][loc[1]]=null;
		}
	}

	public boolean pathBlocked(int[] loc, Piece[][] board){
		int xStart;
		int xEnd;
		int yStart;
		int yEnd;

		if(board[loc[0]][loc[1]].getTeam() != team || board[loc[0]][loc[1]] == null){

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
						return true;
					}
				}
			}
			return false;
		}
		return true;
	}


	/** Feed current or proposed location of the King */
	public boolean canCheck(int[] loc, Piece[][] board){ //Must do as generic location to allow make it able to add to move validation for king
		if(canMove(loc, board)){
			check = true;
			return true;
		}
		check = false;
		return false;
	}

	public abstract boolean move(int[] loc, Piece[][] board, MoveLog log);

	public abstract boolean moveValid(int[] loc, Piece[][] board);
}
