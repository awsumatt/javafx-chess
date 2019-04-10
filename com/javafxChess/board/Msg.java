package com.javafxChess.board;

import javafx.beans.property.SimpleStringProperty;
import com.javafxChess.pieces.*;


public class Msg{
	private SimpleStringProperty team;
	private SimpleStringProperty alert;

	public Msg(boolean team, int type){
		if(team){
			this.team=new SimpleStringProperty("White");
		} else {
			this.team=new SimpleStringProperty("Black");
		}

		if(type==0){
			alert=new SimpleStringProperty("Move invalid!");
		}else if(type==1){
			alert=new SimpleStringProperty("Your turn!");
		} else if(type==2){
			alert=new SimpleStringProperty("Your piece has been captured!");
		} else if (type==3){
			alert=new SimpleStringProperty("You are in check!");
		} else if (type==69){
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
