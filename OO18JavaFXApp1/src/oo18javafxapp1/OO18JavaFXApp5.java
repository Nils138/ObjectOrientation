/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oo18javafxapp1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class OO18JavaFXApp5 extends Application {
  
  @Override
public void start(Stage stage) {
  Button btn = new Button();
  btn.setText("Say \"Hi\"");
  btn.setOnAction(e -> System.out.println("Hi"));
  StackPane root = new StackPane(btn);
//  root.getChildren().add(btn);
  Scene scene = new Scene(root, 200, 150);    
  stage.setTitle("Hi World!");
  stage.setScene(scene);
  stage.show();
}

  public static void main(String[] args) {
    launch(args);
  }
  
}
