package com.internshala;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader= new FXMLLoader(getClass().getResource("sample.fxml"));
        Pane pane =loader.load();
        controller=loader.getController();
        Scene scene=new Scene(pane);




        primaryStage.setTitle("2048");
        primaryStage.setScene(scene);
        primaryStage.setHeight(570);
        primaryStage.setWidth(990);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
