package connect4;
public class Player {
private String symbol;
private String name;
public Player (String n,String s){
	name=n;
	symbol=s;
}
public String getsymbol(){
	return symbol;
}
public String getname(){
	return name;
}

}
