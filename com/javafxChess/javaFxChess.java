
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


	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("gameUI.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("JavaFX Chess");
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static void main(String[] args) {
    launch(args);
}



}
