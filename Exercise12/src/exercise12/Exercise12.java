/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise12;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 *
 * @author Nils Kimman s1007368
 * @author Ole ten Hove s1007616
 */
public class Exercise12 extends Application {

    private static int timesClicked = 1;
    private static ArrayList<Circle> beads = new ArrayList<Circle>();

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 300, 250);

        Line line = new Line(0, 0, 150, 125);
        Circle circle = new Circle(150, 125, 10, Color.rgb(0, 0, 255));
        pane.getChildren().addAll(circle, line);

        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                timesClicked++;
                Circle circle3 = new Circle(10);
                beads.add(circle3);
                pane.getChildren().add(circle3);
                for (int i = 0; i < beads.size(); i++) {
                    double factor = ((double) (i + 1) / timesClicked);
                    Circle circle = beads.get(i);
                    circle.setCenterX(factor * event.getX());
                    circle.setCenterY(factor * event.getY());
                    int red = (int) (255 - factor * 255);
                    circle.setFill(Color.rgb(red, 0, (int) (factor * 255)));
                }
            }

        });

        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                circle.setCenterX(event.getX());
                circle.setCenterY(event.getY());
                line.setEndX(event.getX());
                line.setEndY(event.getY());
                for (int i = 0; i < beads.size(); i++) {
                    double factor = ((double) (i + 1) / timesClicked);
                    Circle circle = beads.get(i);
                    circle.setCenterX(factor * event.getX());
                    circle.setCenterY(factor * event.getY());
                }
            }
        });

        primaryStage.setTitle("A String of Beads");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
