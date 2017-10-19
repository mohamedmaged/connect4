/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import javafx.application.Application;

import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.layout.Pane;

import javafx.stage.Stage;


/**
 *
 * @author User
 */
public class Connect4 extends Application {
    private static final  int TITLE_SIZE=80;
    BoardGui myGui=new BoardGui();
     Pane coinRoot=new Pane();
Board myBoard=new Board();
Player one=new Player("red","#");
Player two=new Player("yellow","*");
    @Override
    public void start(Stage primaryStage) {
       
      primaryStage.setTitle("connect 4");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private Parent createContent() {
        Pane root=new Pane();
        myBoard.create(myBoard);
        root.getChildren().add(myGui.makeGrid());
        root.getChildren().add(coinRoot);
        root.getChildren().addAll(myGui.colums(myBoard,coinRoot,one,two));
        return root;
    }
        }


