
package com.javafxChess;


import javafx.fxml.FXML;
import java.io.FileNotFoundException;
import com.javafxChess.board.*;
import com.javafxChess.pieces.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;


public class javaFxChess extends Application{

	private boolean play = false;
	private boolean turn = true;
	private Piece[][] board;
	private MoveLog log;


	@FXML
	public void startGame() throws FileNotFoundException{
		play=true;
		board = Board.makeBoard();
		Board.initializeBoard(board);
		log = new MoveLog();
	}


	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("gameUI.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("JavaFX Chess");
		primaryStage.setScene(scene);
		primaryStage.show();
	}



}
