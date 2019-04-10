
package com.javafxChess;


<<<<<<< HEAD
import javafx.fxml.FXML;
import java.io.FileNotFoundException;
import com.javafxChess.board.*;
import com.javafxChess.pieces.*;
=======
import java.io.FileNotFoundException;
import com.javafxChess.board.MoveLog;
import com.javafxChess.board.Board;
import com.javafxChess.pieces.Piece;
>>>>>>> acbed3e9e006a711513238e3a0745ebdc48452ef
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import java.io.IOException;


public class javaFxChess extends Application{

	private boolean play = false;
<<<<<<< HEAD
	private boolean turn = true;
=======
>>>>>>> acbed3e9e006a711513238e3a0745ebdc48452ef
	private Piece[][] board;
	private MoveLog log;



<<<<<<< HEAD
	@FXML
=======
>>>>>>> acbed3e9e006a711513238e3a0745ebdc48452ef
	public void startGame() throws FileNotFoundException{
		play=true;
		board = Board.makeBoard();
		Board.initializeBoard(board);
		log = new MoveLog();
<<<<<<< HEAD


=======
>>>>>>> acbed3e9e006a711513238e3a0745ebdc48452ef
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
