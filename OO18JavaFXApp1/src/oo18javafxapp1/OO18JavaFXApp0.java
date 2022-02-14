/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo18javafxapp1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class OO18JavaFXApp0 extends Application {
  
  @Override
  public void start(Stage stage) {
    Circle circle = new Circle(100, 50, 40);
    circle.setFill(Color.RED);
    Pane pane = new Pane(circle);
    Scene scene = new Scene(pane, 200, 100);
    stage.setTitle("My JavaFX App");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
