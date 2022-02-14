/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo18javafxapp1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class OO18JavaFXApp3 extends Application {
  
  @Override
  public void start(Stage stage) {
    Circle circle = new Circle(100, 50, 40);
    circle.setFill(Color.RED);
    Pane pane = new Pane(circle);
    Scene scene = new Scene(pane, 200, 100);
    stage.setTitle("My JavaFX App");
    stage.setScene(scene);
    stage.show();

    Stage stage2 = new Stage();
    stage2.setTitle("Stage 2");
    Circle circle2 = new Circle(80, 50, 40);
    circle2.setFill(Color.BLUE);
    stage2.setScene(new Scene(new Pane(circle2), 150, 90));
    stage2.show();

    Stage stage3 = new Stage();
    stage3.setTitle("Stage 3");
    Circle circle3 = new Circle(50);
    circle3.centerXProperty().bind(stage3.widthProperty().multiply(0.4));
    circle3.centerYProperty().bind(stage3.heightProperty().multiply(0.5));
    stage3.setScene(new Scene(new Pane(circle3), 200, 200));
    stage3.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
