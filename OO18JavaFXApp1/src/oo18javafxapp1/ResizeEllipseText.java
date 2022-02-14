/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo18javafxapp1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class ResizeEllipseText extends Application {
  
  @Override
  public void start(Stage stage) {
    Ellipse ellipse = new Ellipse();
    ellipse.setFill(Color.RED);
    StackPane ellipsePane = new StackPane(ellipse);
    ellipse.radiusXProperty().bind(ellipsePane.widthProperty().multiply(0.45));
    ellipse.radiusYProperty().bind(ellipsePane.heightProperty().multiply(0.45));
    BorderPane root = new BorderPane();
    root.setCenter(ellipsePane);
    FlowPane textPane = new FlowPane();
    textPane.setAlignment(Pos.CENTER);
    textPane.setHgap(4);
    Label xText = new Label("x"), yText = new Label("y");
    textPane.getChildren().addAll(xText, yText);
    root.setBottom(textPane);
    ellipse.radiusXProperty().addListener(
        (o, n, m) -> xText.setText(String.format("rx = %1.1f", m)));
    ellipse.radiusYProperty().addListener(
        (o, n, m) -> yText.setText(String.format("ry = %1.1f", m)));
    Scene scene = new Scene(root, 200, 100);
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
