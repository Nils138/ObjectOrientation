/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo18javafxapp1;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class PolygonDemo extends Application {
  private final int N = 14;
  public void start(Stage stage) {
    Pane root = new StackPane();
    Polygon poly = new Polygon();
    root.getChildren().add(poly);
    poly.setFill(Color.YELLOW);
    poly.setStroke(Color.RED);
    ObservableList<Double> list = poly.getPoints();
    for (int i = 0; i < N; i += 1) {
      int r = (i % 2 == 0) ? 100 : 30;
      list.add(r * Math.cos(2 * Math.PI * i / N));
      list.add(r * Math.sin(2 * Math.PI * i / N));
    }
    Scene scene = new Scene(root, 220, 220);
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
