package com.example.dimlom;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;


import java.io.File;
import java.io.IOException;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1500, 1000);
        stage.setTitle("Is it readable?");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        File file = new File("src\\sample\\text.txt");

        launch();
    }
}