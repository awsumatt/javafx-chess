package com.javafxChess;


import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
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
import java.lang.Math;
import javafx.concurrent.Task;



public class Controller implements Initializable
{
	@FXML
	private TableView table;
	@FXML
	private TableColumn teamCol;
	@FXML
	private TableColumn msgCol;
	@FXML
	private Button startBtn;
	@FXML
	private GridPane boardPane;
	@FXML
	private ImageView kingB;
	@FXML
	private ImageView queenB;
	@FXML
	private ImageView bishopB1;
	@FXML
	private ImageView bishopB2;
	@FXML
	private ImageView knightB1;
	@FXML
	private ImageView knightB2;
	@FXML
	private ImageView rookB1;
	@FXML
	private ImageView rookB2;
	@FXML
	private ImageView pawnB1;
	@FXML
	private ImageView pawnB2;
	@FXML
	private ImageView pawnB3;
	@FXML
	private ImageView pawnB4;
	@FXML
	private ImageView pawnB5;
	@FXML
	private ImageView pawnB6;
	@FXML
	private ImageView pawnB7;
	@FXML
	private ImageView pawnB8;
	@FXML
	private ImageView kingW;
	@FXML
	private ImageView queenW;
	@FXML
	private ImageView bishopW1;
	@FXML
	private ImageView bishopW2;
	@FXML
	private ImageView knightW1;
	@FXML
	private ImageView knightW2;
	@FXML
	private ImageView rookW1;
	@FXML
	private ImageView rookW2;
	@FXML
	private ImageView pawnW1;
	@FXML
	private ImageView pawnW2;
	@FXML
	private ImageView pawnW3;
	@FXML
	private ImageView pawnW4;
	@FXML
	private ImageView pawnW5;
	@FXML
	private ImageView pawnW6;
	@FXML
	private ImageView pawnW7;
	@FXML
	private ImageView pawnW8;
	private boolean play = false;
	private boolean turn = true;
	private boolean clicked = false;
	private Piece[][] board;
	private MoveLog log;
	private int moveX;
	private int moveY;
	private Double dubX;
	private Double dubY;
	private int[] start;
	private int[] end;
	final private int INV_MOVE = 0;
	final private int NEW_TURN = 1;



	@Override
	public void initialize(URL url, ResourceBundle resourceBundle){
	}


	public int[] getMove(){
		while(!clicked){}
			clicked = false;
		return new int[]{moveX, moveY};
	}

	@FXML
	public void startGame() throws FileNotFoundException{
		boardPane.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
	    dubX = new Double(Math.floor(e.getX()/50));
	    dubY = new Double(Math.floor(e.getY()/50));
			moveX = dubX.intValue();
			moveY = dubY.intValue();
			clicked=true;
	});
		startBtn.setDisable(true);
		play=true;
		board = Board.makeBoard();
		Board.initializeBoard(board, boardPane, kingB, queenB, bishopB1, bishopB2, knightB1, knightB2, rookB1, rookB2, pawnB1, pawnB2, pawnB3, pawnB4, pawnB5, pawnB6, pawnB7, pawnB8, kingW, queenW, bishopW1, bishopW2, knightW1, knightW2, rookW1, rookW2, pawnW1, pawnW2, pawnW3, pawnW4, pawnW5, pawnW6, pawnW7, pawnW8);
		ObservableList<Msg> messages = FXCollections.observableArrayList(
		new Msg(turn, NEW_TURN)
		);
		log = new MoveLog(messages);

		Task game = new Task<Void>() {
    @Override public Void call() {
			playGame(messages);
			return null;
    }
};



		teamCol.setCellValueFactory(
			new PropertyValueFactory<Msg,String>("team")
		);
		msgCol.setCellValueFactory(
			new PropertyValueFactory<Msg,String>("alert")
		);

		table.setItems(messages);

		new Thread(game).start();
	}




	private void playGame(ObservableList<Msg> messages){
		while(play){
			start = getMove();
			if(board[start[0]][start[1]] != null){
				if (board[start[0]][start[1]].getTeam()==turn) {
					end = getMove();
					board[start[0]][start[1]].move(end, board, log);
				} else {
					messages.add(new Msg(turn, INV_MOVE));
				}
			} else {
				messages.add(new Msg(turn, INV_MOVE));
			}
			log.close();
			play=false;
		}
	}


}
