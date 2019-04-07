package com.javafxChess.board;

import java.lang.StringBuilder;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;

public class MoveLog{

	final private File gameNum = "/logs/.gameNumber";
	final private File logFile;
	final private PrintWriter writer;


	public MoveLog(){
		logFile = makeNewLog();
		writer = new PrintWriter(logFile);
	}

	public String makeNewLog(){
		int num;
		String logName;
		Scanner input = new Scanner(gameNum);

		num = input.nextInt();
		input.close();
		logName = "chess"+num+".txt";
		num+=1;

		PrintWriter write = new PrintWriter(gameNum);
		write.print(num);
		write.close();
		return logName;
	}


	//These two are conversions for board coordinates
	public int numToNum(int y){
		return 8-y;
	}

	public char numToChar(int x){
		return x+65;
	}

	/** Converts team boolean to string */
	public String boolToTeam(boolean team){
		if(team){
			return "White";
		} else{
			return "Black";
		}
	}

	/** Translates the move into a string */
	public String moveToString(Piece piece, int[] startLoc, int[] endLoc){
		StringBuilder move = new StringBuilder();
		move.append(boolToTeam(piece.getTeam())+" ");
		move.append(piece+", ");
		move.append(numToChar(startLoc[0])+numToNum(startLoc[1])+" to "+numToChar(endLoc[0])+numToNum(endLoc[1]));
		writer.println(move.toString());
	}

	/** Translates a piece capture into a string */
	public String captureToString(Piece piece1, Piece piece2){
		StringBuilder capture = new StringBuilder();
		capture.append(boolToTeam(piece1.getTeam())+" "+piece1);
		capture.append(" has captured ");
		capture.append(boolToTeam(piece2.getTeam())+" "+piece2+"!");
		writer.println(capture.toString());
	}



}
