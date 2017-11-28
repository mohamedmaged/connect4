/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect4;

/**
 *
 * @author User
 */
import javafx.scene.control.Alert;


public class FullColumnException extends Exception {
    
    public FullColumnException(){
       
    }
    
    public void handleException(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText(" Warning");
        alert.setContentText("Wrong colum to play in !");

        alert.showAndWait();  
    }
}
