package com.javafxChess.pieces;

import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import com.javafxChess.board.MoveLog;

public class Rook extends Piece{
	private Boolean canCastle;

	/**
	*Initializes rook with a specific location
	*
	*@param team true=white team, false=black team
	*@param location Location in (x,y) format
	*/
	public Rook(boolean team, int[] location, ImageView pic, GridPane pane) {
		super(team, location, pic, pane);
		this.setName("Rook");
		canCastle = true;
	}

	/**
	 * @param loc Location to move the piece
	 * @param board The board the piece is on
	 *
	 * @return True if the move is valid, false otherwise
	 */
	@Override
	public boolean move(int[] loc, Piece[][] board, MoveLog log) {
		if(moveValid(loc, board)){
			board[this.getX()][this.getY()] = null;
			log.moveToString(this, location, loc);
			location = loc;
			ifEnemyRemove(loc, board, log);
			board[this.getX()][this.getY()] = this;
			canCastle = false;
			return true;

		}
		log.moveInv(this);
		return false;
	}

	public Boolean getCanCastle() {
		return canCastle;
	}

	public char getSide() {
		if(location[0] < 5) {
			return 'q';
		}
		return 'k';
	}

	public boolean moveValid(int[] loc, Piece[][] board) {
		if(pathBlocked(loc, board)) {
			if(getX() == loc[0] && getY() != loc[1] && moveValid(loc, board)) {;
				return true;
			} else if(getX() != loc[0] && getY() == loc[1] && moveValid(loc, board)) {
				return true;
			}
		}
		return false;
	}
}
