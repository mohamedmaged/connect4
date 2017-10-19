package connect4;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Board {
	private static final int row=6;///row number
	private static final int  colum=7;//column number

    public static int getRow() {
        return row;
    }

    public static int getColum() {
        return colum;
    }
	   public  String [][]arr=new String[row][colum];
	   public void   create (Board ar){
	       
		      //  int row=6,colum=7;
		  
		     for(int i=0;i<row;i++){
		    
		         for(int j=0;j<colum;j++)
		     {
		   ar. arr[i][j]=" ";  // store the blank spaces
		     }
		     }
		    
		}
	  public int  play(Board ar,int colum,Player x)
	    {
                int i;
	        for( i=5;i>=0;i--)
	        {
	            if(ar.arr[i][colum].equals(" ")) // knows the last play in this colum 
	            {
	                arr[i][colum]=x.getsymbol();
	                break;
	            }
	        }
                return i;
	    }
public boolean check_before_play(int colum,Board ar){
	 if(colum>6)   // if he enter a colum number exceeded the limit 
     {
         System.out.println("wrong colum");
         return false;         
     }
	 else if(ar.arr[0][colum]!=" ") // check if the colum isn't already filled 
     {
Alert alert = new Alert(AlertType.WARNING);
alert.setTitle("Warning Dialog");
alert.setHeaderText(" Warning");
alert.setContentText("Wrong colum to play in !");

alert.showAndWait();         return false;
     }
	 
	return true;
}

public boolean check_for_winner(Board ar ,Player x){
	for(int i =0;i<6;i++)
    {
        for(int j=0;j<=3;j++)
        {
            if((ar.arr[i][j].equals(x.getsymbol())) && (ar.arr[i][j+1].equals(x.getsymbol()))&&(ar.arr[i][j+2].equals(x.getsymbol()))&&(ar.arr[i][j+3].equals(x.getsymbol()))) // check for the winner in the same row
            	return true;
        }
      
    }
	for(int i=0;i<7;i++)
    {
        for(int j=0;j<=2;j++)
        {
            if((x.getsymbol().equals(ar.arr[j][i]))&&(x.getsymbol().equals(ar.arr[j+1][i]))&&(x.getsymbol().equals(ar.arr[j+2][i]))&&(x.getsymbol().equals(ar.arr[j+3][i]))) //check for the winner in the same colums
            	return true;
        }
        
    }
	for(int i=0;i<=3;i++)
    {
        for(int j=0;j<=2;j++)
        {
            if((x.getsymbol().equals(ar.arr[j][i]))&&(x.getsymbol().equals(ar.arr[j+1][i+1]))&&(x.getsymbol().equals(ar.arr[j+2][i+2]))&&(x.getsymbol().equals(ar.arr[j+3][i+3]))) //check for a winner  in a diagonal with positive slope 
                return true; 
        }
       
    }
    for(int i=0;i<=2;i++)
    {
        for(int j=6;j>=3;j--)
        {
            if((ar.arr[i][j].equals(x.getsymbol()))&&(ar.arr[i+1][j-1].equals(x.getsymbol()))&&(ar.arr[i+2][j-2].equals(x.getsymbol()))&&(ar.arr[i+3][j-3].equals(x.getsymbol()))) // check for a winner in a diagonal with negative slope
                return true;
        }
       
    }
	return false ;
}
public boolean check_empty(Board ar){
	 for(int i=0;i<colum;i++){
		    if(ar.arr[1][i].equals(" "))
		    	return true;
     }
	return false ;
}

}
