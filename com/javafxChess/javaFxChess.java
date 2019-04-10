package com.javafxChess;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;
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



}
