package com.javafxChess.board;

import javafx.beans.property.SimpleStringProperty;

/** Creates messages to prompt user */
public class Msg{
	private SimpleStringProperty team;
	private SimpleStringProperty alert;
	final private int INV_MOVE = 0;
	final private int NEW_TURN = 1;
	final private int PIECE_CAP = 2;
	final private int CHECK = 3;
	final private int WIN = 69;

	public Msg(boolean team, int type){
		if(team){
			this.team=new SimpleStringProperty("White");
		} else {
			this.team=new SimpleStringProperty("Black");
		}

		if(type==INV_MOVE){
			alert=new SimpleStringProperty("Move invalid!");
		}else if(type==NEW_TURN){
			alert=new SimpleStringProperty("Your turn!");
		} else if(type==PIECE_CAP){
			alert=new SimpleStringProperty("Your piece has been captured!");
		} else if (type==CHECK){
			alert=new SimpleStringProperty("You are in check!");
		} else if (type==WIN){
			alert=new SimpleStringProperty("You win!");
		}
	}


	public String getTeam(){
		return team.get();
	}

	public String getAlert(){
		return alert.get();
	}


}
