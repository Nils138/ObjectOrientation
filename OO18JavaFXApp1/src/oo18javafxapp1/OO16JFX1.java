/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo18javafxapp1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Nils Kimman
 */
public class OO16JFX1 extends Application {

    private static int time;
    private static int total;
    private static Timeline timeline;
    private static TextField text;
    private static Rectangle rect;
    private static ProgressBar bar;

    @Override
    public void start(Stage s) {
        bar = new ProgressBar(1);
        rect = new Rectangle(0, 0, s.getMaxHeight(), s.getMaxWidth());
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), this::tickHandler));
        Button start = new Button();
        start.setText("Start");
        start.setOnAction(e -> startHandler(e));
        Button stop = new Button();
        stop.setText("Stop");
        stop.setOnAction((e) -> {
            timeline.stop();
            rect.setFill(Color.WHITE);
        });
        Button quit = new Button();
        quit.setText("Quit");
        quit.setOnAction((e) -> {
            Platform.exit();
        });
        Pane root = new Pane(start, stop, quit, rect);
        Scene scene = new Scene(root, 150, 50);
        s.setScene(scene);
        s.setTitle("Time Flies");
        s.show();
        timeline.stop();

    }
    
    public void startHandler(ActionEvent e) {
        timeline.play();
        rect.setFill(Color.WHITE);
        time = total = Integer.parseInt(text.getText());
    }

    public void tickHandler(ActionEvent e) {
        time--;
        bar.setProgress((double) time / total);
        if (time == 0) {
            rect.setFill(Color.RED);
            timeline.stop();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
