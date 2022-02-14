/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo18javafxapp1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class OO18JavaFXApp6 extends Application {
  
  @Override
  public void start(Stage stage) {
    Label label = new Label("Hello OO");
    Pane pane = new Pane(label);
    stage.setTitle("Label GUI");
    stage.setScene(new Scene(pane, 200, 100));
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
