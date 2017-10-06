/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

/**
 *
 * @author User
 */
public class BoardGui {
  
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

}
