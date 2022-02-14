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
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class RectangleDemo extends Application {
  
  @Override
  public void start(Stage primaryStage) {
    Rectangle rect = new Rectangle(200, 100);
    rect.setArcHeight(40);
    rect.setArcWidth(60);
    rect.setFill(Color.ORANGE);
    rect.setStroke(Color.DARKORANGE);
    rect.setStrokeWidth(3);
    Label label = new Label("Click to turn");
    label.setTextFill(Color.WHITE);
    StackPane root = new StackPane();
    root.getChildren().addAll(rect, label);
    Scene scene = new Scene(root, 300, 250);
    root.setOnMouseClicked( e -> root.setRotate(root.getRotate() + 15));
    primaryStage.setTitle(this.getClass().getSimpleName());
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
