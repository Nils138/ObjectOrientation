/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo18javafxapp1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class ResizeEllipse extends Application {
  @Override
  public void start(Stage stage) {
  Ellipse ellipse = new Ellipse();
  ellipse.setFill(Color.RED);
  Pane root = new StackPane(ellipse);
  ellipse.radiusXProperty().bind(root.widthProperty().multiply(0.45));
  ellipse.radiusYProperty().bind(root.heightProperty().multiply(0.45));
  Scene scene = new Scene(root, 200, 100);
  stage.setTitle(this.getClass().getSimpleName());
  stage.setScene(scene);
  stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
