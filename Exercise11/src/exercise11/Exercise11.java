/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise11;

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
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.layout.VBox;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Exercise11 extends Application {

    //variables; need to be declared here because of scope issues
    private static int timer;
    private static double maxTimer; //needs to be a double for division
    private static Timeline timeLine;
    private static ProgressBar progress;
    private static VBox vbox;

    @Override
    public void start(Stage primaryStage) {

        //components
        Button start = new Button();
        start.setText("Start");
        Button quit = new Button();
        quit.setText("Quit");
        Button stop = new Button();
        stop.setText("Stop");
        TextField input = new TextField();
        progress = new ProgressBar(1.0);
        vbox = new VBox();
        vbox.getChildren().addAll(start, quit, stop, input, progress);

        //Timeline
        timeLine = new Timeline(new KeyFrame(Duration.seconds(1), this::tickHandler));
        timeLine.setCycleCount(Timeline.INDEFINITE);

        //buttons
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timer = Integer.parseInt(input.getText());
                maxTimer = timer;
                timeLine.play();
            }
        });
        stop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                timeLine.stop();
            }
        });
        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });

        //scene/stage
        Scene scene = new Scene(vbox, 150, 130);

        primaryStage.setTitle("Time flies");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * function which is executed every second when the Timeline plays
     * lowers the timer by a second and updates the progress bar
     * @param event 
     */
    
    private void tickHandler(ActionEvent event) {
        timer--;
        double currentProgress = (double) timer / maxTimer;
        progress.setProgress(currentProgress);
        if (timer == 0) {
            timeLine.stop();
            vbox.setStyle("-fx-background: #FF0000");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
