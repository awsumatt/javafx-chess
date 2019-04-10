package com.javafxChess.board;

import com.javafxChess.pieces.Piece;
import java.lang.StringBuilder;
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class MoveLog{

	/** File where game number is stored */
	final private File gameNum = new File("logs/.gameNumber");
	/** File where moves will be logged */
	final private File logFile;
	/** Writes moves to the log file */
	final private PrintWriter writer;

	/** Initializes a move log */
	public MoveLog()  throws FileNotFoundException{
		logFile = makeNewLog();
		writer = new PrintWriter(logFile);
	}

	/** Checks the game number, uses it to name the logfile, then sets new gameNumber for next game */
	private File makeNewLog() throws FileNotFoundException{
		int num;
		File logName;
		Scanner input = new Scanner(gameNum);

		num = input.nextInt();
		input.close();
		logName = new File("chess"+num+".txt");
		num+=1;

		PrintWriter write = new PrintWriter(gameNum);
		write.print(num);
		write.close();
		return logName;
	}


	//These two are conversions for board coordinates
	private int numToNum(int y){
		return 8-y;
	}

	private char numToChar(int x){
		char letter = 65;
		letter += x;
		return letter;
	}

	/** Converts team boolean to string */
	private String boolToTeam(boolean team){
		if(team){
			return "White";
		} else{
			return "Black";
		}
	}

	/** Closes log file and saves contents */
	public void close(){
		writer.close();
	}

	/** Translates the move into a string */
	public void moveToString(Piece piece, int[] startLoc, int[] endLoc){
		StringBuilder move = new StringBuilder();
		move.append(boolToTeam(piece.getTeam())+" ");
		move.append(piece+", ");
		move.append(numToChar(startLoc[0])+numToNum(startLoc[1])+" to "+numToChar(endLoc[0])+numToNum(endLoc[1]));
		writer.println(move.toString());
	}

	/** Translates a piece capture into a string */
	public void captureToString(Piece piece1, Piece piece2){
		StringBuilder capture = new StringBuilder();
		capture.append(boolToTeam(piece1.getTeam())+" "+piece1);
		capture.append(" has captured ");
		capture.append(boolToTeam(piece2.getTeam())+" "+piece2+"!");
		writer.println(capture.toString());
	}



}
