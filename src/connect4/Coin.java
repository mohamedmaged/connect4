/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author User
 */
public class Coin extends Circle{
    private boolean red;
    public Coin(boolean red)
    {
       super(80/2,red ? Color.RED : Color.YELLOW);
        this.red=red;
        setCenterX(40);
        setCenterY(40);
    }
    
}
