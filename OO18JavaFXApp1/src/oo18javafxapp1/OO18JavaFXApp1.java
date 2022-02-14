/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo18javafxapp1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class OO18JavaFXApp1 extends Application {
    
    int timer;
    
    @Override
    public void start(Stage stage) {
        Button start = new Button();
        start.setText("Start");
        Button quit = new Button();
        quit.setText("Quit");
        Button stop = new Button();
        stop.setText("Stop");
        TextField input = new TextField();
        ProgressBar progress = new ProgressBar();
        VBox vbox = new VBox();
        vbox.getChildren().addAll(start, quit, stop, input, progress);
        Scene scene = new Scene(vbox, 400, 400);
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timer = Integer.parseInt(input.getText());
                System.out.println(timer);
            }
        });

        stage.setTitle("Time flies");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
