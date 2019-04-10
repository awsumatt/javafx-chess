package com.javafxChess;


import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ListView;
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
	@FXML
	private TableView table;
	@FXML
	private TableColumn teamCol;
	@FXML
	private TableColumn msgCol;
	@FXML
	private Button startBtn;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
	}

	@FXML
	public void startGame() throws FileNotFoundException{
		startBtn.setDisable(true);
		play=true;
		board = Board.makeBoard();
		Board.initializeBoard(board);
		log = new MoveLog();

		ObservableList<Msg> messages = FXCollections.observableArrayList(
    new Msg(true, 1)
		);

		teamCol.setCellValueFactory(
    	new PropertyValueFactory<Msg,String>("team")
		);
		msgCol.setCellValueFactory(
    	new PropertyValueFactory<Msg,String>("alert")
		);

		table.setItems(messages);

		log.close();
		startBtn.setDisable(false);
	}
}
