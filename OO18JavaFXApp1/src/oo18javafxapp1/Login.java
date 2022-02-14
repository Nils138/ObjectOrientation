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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author pieterkoopman
 */
public class Login extends Application {
  private String pwd;
  public void start(Stage stage) {
    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(5);
    grid.setVgap(10);
    
    Label heading = new Label("Enter name and password");
    heading.setFont(Font.font(18));
    grid.add(heading, 0, 0, 2, 1);
    
    grid.add(new Label("name"),0,1);
    grid.add(new Label("Password"),0,2);
    TextField nameField = new TextField("user");
    TextField pwdField  = new PasswordField();
    pwdField.setTooltip(new Tooltip("At least 1 letter"));
    grid.add(nameField, 1, 1);
    grid.add(pwdField,  1, 2);
    Label feedback = new Label("");
    grid.add(feedback, 0, 4, 2, 1);
    
    Button btn = new Button();
    btn.setText("ok");
    btn.setOnAction(e -> {
      String pwd1 = pwdField.getText();
      String name = nameField.getText();
      if (!pwd1.isEmpty() && ! name.isEmpty() && pwd1.equals(pwd)) {
        stage.close();
      } else {
        feedback.setText(name + " re-enter \"" + pwd1 + "\" to confrim.");
        pwd = pwd1;
        pwdField.clear();
      }
    });
    grid.add(btn, 1, 3);
    
    Scene scene = new Scene(grid, 300, 200);
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
