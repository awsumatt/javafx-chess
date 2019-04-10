package com.javafxChess;

import java.io.FileNotFoundException;
import com.javafxChess.board.*;
import com.javafxChess.pieces.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable
{
	private boolean play = false;
	private boolean turn = true;
	private Piece[][] board;
	private MoveLog log;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
    }

		@FXML
		public void startGame() throws FileNotFoundException{
			play=true;
			board = Board.makeBoard();
			Board.initializeBoard(board);
			log = new MoveLog();
		}
}
