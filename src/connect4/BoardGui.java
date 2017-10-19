/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

/**
 *
 * @author User
 */
public class BoardGui {
  boolean red=true;
  int n=0;
    private static final  int TITLE_SIZE=80;


public Shape makeGrid() {
        Shape shape=new Rectangle(8*TITLE_SIZE,TITLE_SIZE*7);
        for(int y=0;y<6;y++)
        {
            for (int x=0;x<7;x++)
            {
               Circle circle=new Circle(TITLE_SIZE/2);
               circle.setCenterX(TITLE_SIZE/2);
               circle.setCenterY(TITLE_SIZE/2);
               circle.setTranslateX( x *(TITLE_SIZE+7)+TITLE_SIZE/4);
                circle.setTranslateY(y *(TITLE_SIZE+7)+TITLE_SIZE/4);
              shape=  shape.subtract(shape, circle);

            }  
        }
        Light.Distant light=new Light.Distant();
        light.setAzimuth(45);
        light.setElevation(30);
        Lighting lightning=new Lighting();
        lightning.setLight(light);
        lightning.setSurfaceScale(5);
        
        shape.setFill(Color.BLUE);
        shape.setEffect(lightning);
        return shape;
    }
 public void placeDisk(Coin coin,int colum,Board myBoard,Pane coinRoot,Player one,Player two)
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
        {
        animation.setToY(myBoard.play(myBoard, colum, one) * (TITLE_SIZE + 7) + TITLE_SIZE / 4);
        coin.setFill(Color.RED);
        }
        else
        {
         animation.setToY(myBoard.play(myBoard, colum, two) * (TITLE_SIZE + 7) + TITLE_SIZE / 4);
                 coin.setFill(Color.YELLOW);
        }

       animation.setOnFinished(e -> {
           /* if (gameEnded(column, currentRow)) {
                gameOver();
            }
            redMove = !redMove;*/
        });
        animation.play();
        if( myBoard.check_for_winner(myBoard, one))
        {
                  winner(one,myBoard,coinRoot);

        }
        if(myBoard.check_for_winner(myBoard, two))
                   {
                  winner(two,myBoard,coinRoot);
    }
                        red=!red;
        }
   public List<Rectangle> colums(Board myBoard,Pane coinRoot,Player one ,Player two){
        List<Rectangle> list=new ArrayList<>();
      
        for (int x = 0; x < 7; x++) {
            Rectangle rec=new Rectangle(TITLE_SIZE,7*TITLE_SIZE);
            rec.setTranslateX( x *(TITLE_SIZE+7)+TITLE_SIZE/4);
            rec.setFill(Color.TRANSPARENT);
            rec.setOnMouseEntered(e->rec.setFill(Color.rgb(200, 200, 50, 0.3)));
            rec.setOnMouseExited(e->rec.setFill(Color.TRANSPARENT));
            list.add(rec);
            
             int colum=x;   
                 rec.setOnMouseClicked(e->placeDisk(new Coin(),colum,myBoard,coinRoot,one,two));
               
        }
        
            return list;

    }
   void winner(Player x,Board myBoard,Pane coinRoot)
{
    Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("There is a winner hohooooh");
alert.setHeaderText("WNNNER");
alert.setContentText("  "+ x.getname() +":  Congratulations you have won ");

ButtonType buttonTypeOne = new ButtonType("Restart");
ButtonType buttonTypeTwo = new ButtonType("EXIT");


alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

Optional<ButtonType> result = alert.showAndWait();
if (result.get() == buttonTypeOne){
    // ... user chose "One"
    coinRoot.getChildren().remove(0, n);
           myBoard.create(myBoard);
           n=0;
} 
else if (result.get() == buttonTypeTwo) {
    // ... user chose "Two"
               System.exit(0);

} 
}
}
