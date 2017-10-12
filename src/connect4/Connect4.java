/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Skin;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

/**
 *
 * @author User
 */
public class Connect4 extends Application {
    private static final  int TITLE_SIZE=80;
    boolean red=true;
    int n=0;
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
        root.getChildren().addAll(colums());
        return root;
    }

  
    private List<Rectangle> colums(){
        List<Rectangle> list=new ArrayList<>();
      
        for (int x = 0; x < 7; x++) {
            Rectangle rec=new Rectangle(TITLE_SIZE,7*TITLE_SIZE);
            rec.setTranslateX( x *(TITLE_SIZE+7)+TITLE_SIZE/4);
            rec.setFill(Color.TRANSPARENT);
            rec.setOnMouseEntered(e->rec.setFill(Color.rgb(200, 200, 50, 0.3)));
            rec.setOnMouseExited(e->rec.setFill(Color.TRANSPARENT));
            list.add(rec);
            
             int colum=x;
            
                 rec.setOnMouseClicked(e->placeDisk(new Coin(red),colum));
             
           
        }
        
            return list;

    }
    private void placeDisk(Coin coin,int colum)
    {
       /* if(!myBoard.check_empty(myBoard))
        {
            Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Information Dialog");
alert.setHeaderText(" Information" );
alert.setContentText("sorry there is no other places to play in ");
alert.showAndWait();
  myBoard.create(myBoard);
 coinRoot.getChildren().remove(0, n);
           n=0;
        }*/
          if(!myBoard.check_before_play(colum, myBoard))
              return;
        coinRoot.getChildren().add(coin);
        n++;
        coin.setTranslateX(colum*(TITLE_SIZE+7)+TITLE_SIZE/4);
       
       
        TranslateTransition animation = new TranslateTransition(Duration.seconds(0.5), coin);
        if(red)
        animation.setToY(myBoard.play(myBoard, colum, one) * (TITLE_SIZE + 7) + TITLE_SIZE / 4);
        else
         animation.setToY(myBoard.play(myBoard, colum, two) * (TITLE_SIZE + 7) + TITLE_SIZE / 4);

       animation.setOnFinished(e -> {
           /* if (gameEnded(column, currentRow)) {
                gameOver();
            }
            redMove = !redMove;*/
        });
        animation.play();
        if( myBoard.check_for_winner(myBoard, one))
        {
           Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Game Over");
alert.setHeaderText("WINNER");
alert.setContentText("RED : CONGRATULATIONS YOU HAVE WON ");

alert.showAndWait();
       /*    System.out.println("red won");
           System.exit(0);
           coinRoot.getChildren().remove(0, n);
           myBoard.create(myBoard);
           n=0;*/
        }
        if(myBoard.check_for_winner(myBoard, two))
                   {
                   Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Game Over");
alert.setHeaderText("WINNER");
alert.setContentText("YELLLOW : CONGRATULATIONS YOU HAVE WON ");
alert.showAndWait();
    }
                        red=!red;
        }
       
       
        }


