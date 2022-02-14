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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class ArcDemo extends Application {
  
  @Override
  public void start(Stage stage) {
    Pane root = new Pane();
    double cx = 200, cy = 100, rx = cx - 20, ry = cy - 20;
    Rectangle rect = new Rectangle(10, 10, 2*cx + 20, 2*cy + 20);
    rect.setFill(Color.PINK);
    root.getChildren().add(rect);
    Arc a1 = new Arc(cx, cy, rx, ry, 30, 40);
    a1.setType(ArcType.OPEN);
    a1.setFill(Color.TRANSPARENT);
    a1.setStroke(Color.BLACK);
    root.getChildren().addAll(a1, new Text(1.2*cx, 40, "a1: open"));
    Arc a2 = new Arc(cx, cy, rx, ry, 120, 40);
    a2.setType(ArcType.CHORD);
    a1.setFill(Color.TRANSPARENT);
    a1.setStroke(Color.BLACK);
    root.getChildren().addAll(a2, new Text(20, 40, "a2: chord"));
    Arc a3 = new Arc(cx, cy, rx, ry, 210, 40);
    a3.setFill(Color.DARKGREY);
    a3.setType(ArcType.ROUND);
    root.getChildren().addAll(a3, new Text(20, 1.5 * cy, "a3: round"));
    Arc a4 = new Arc(cx, cy, rx, ry, 300, 40);
    a4.setType(ArcType.CHORD);
    a4.setFill(Color.TRANSPARENT);
    a4.setStroke(Color.WHITE);
    root.getChildren().addAll(a4, new Text(1.2 * cx, 1.5 * cy, "a4: chord"));
    Scene scene = new Scene(root, 2 * cx + 40, 2 * cy + 40);
    stage.setTitle(this.getClass().getSimpleName());
    stage.setScene(scene);
    stage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }
  
}
