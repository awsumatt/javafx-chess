package com.javafxChess.board;

import java.lang.StringBuilder;
import java.io.PrintWriter;
import java.io.File;

public class moveLog{

	public int numToNum(int y){
		return 8-y;
	}

	public char numToChar(int x){
		return x+65;
	}

	public String boolToTeam(boolean team){
		if(team){
			return "White";
		} else{
			return "Black";
		}
	}

	public String moveToString(Piece piece, int[] startLoc, int[] endLoc){
		StringBuilder move = new StringBuilder();
		move.append(boolToTeam(piece.getTeam())+" ");
		move.append(piece+", ");
		move.append(numToChar(startLoc[0])+numToNum(startLoc[1])+" to "+numToChar(endLoc[0])+numToNum(endLoc[1]));
		return move.toString();
	}

	public String captureToString(Piece piece1, Piece piece2){
		StringBuilder capture = new StringBuilder();
		capture.append(boolToTeam(piece1.getTeam())+" "+piece1);
		capture.append(" has captured ");
		capture.append(boolToTeam(piece2.getTeam())+" "+piece2+"!");
	}



}
