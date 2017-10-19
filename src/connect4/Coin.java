/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

import javafx.scene.shape.Circle;

/**
 *
 * @author User
 */
public class Coin extends Circle{
    public Coin()
    {
       super(80/2);
        setCenterX(40);
        setCenterY(40);
    }
    
}
