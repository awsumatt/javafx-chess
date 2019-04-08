package com.javafxChess.pieces;
import com.javafxChess.board.MoveLog;

public class King extends Piece{
	private Boolean canCastle = true;
	/**
	*Initializes king with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*@param log Logger that the move will be stored in
	*/
	public King(boolean team, int[] location, MoveLog log){
		super(team, location);
		this.setName("King");
	}

	/**
	*Initializes king with the default location
	*
	*@param team true=white team, false=black team
	*/
	public King(boolean team){
		super(team);
		if(team){ //White team default location
			location[0] = 4;
			location[1] = 7;
		} else { //Black team default location
			location[0] = 4;
			location[1] = 0;
		}

	}

	/**
	*@return True if move valid, false otherwise
	*/
	public boolean move(int[] loc, Piece[][] board, MoveLog log){
		if(moveValid(loc, board)){
			board[this.getX()][this.getY()] = null;
			log.moveToString(this, location, loc);
			location = loc;
			ifEnemyRemove(loc, board, log);
			board[this.getX()][this.getY()] = this;
			canCastle = false;
			return true;

		}
		return false;
	}

	public boolean moveValid(int[] loc, Piece[][] board) {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if((board[i][j] != null || board[i][j].getName() != "Pawn") && board[i][j].moveValid(loc, board)) {
					return false;
				} else if(board[i][j].getName() == "Pawn" && ((Pawn) board[i][j]).moveAttack(loc, board)) {
					return false;
				}
			}
		}
		
		if(board[loc[0]][loc[1]].getName() == "Rook" && board[loc[0]][loc[1]].getTeam() == this.getTeam()) {
			if(((Rook) board[loc[0]][loc[1]]).getCanCastle() && canCastle) {
				return castle(loc, board);
			}
		}
		return true;
	}

	
	private boolean castle(int[] loc, Piece[][] board) {
		char side = ((Rook) board[loc[0]][loc[1]]).getSide();
		if(side == 'q') {
			int[] check = {2, this.getY()};
			if(!pathBlocked(check, board)) {
				return true;
			}
		} else if(side == 'k') {
			int[] check = {6, this.getY()};
			if(!pathBlocked(check, board)) {
				return true;
			}
		}
		return false;
	}
}
