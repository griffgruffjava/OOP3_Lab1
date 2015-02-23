import java.io.Serializable;

/** models a game player, with name and score*/
public class Player extends Person implements Serializable{
  
  private int score;
  private BankAccount ba;
  private boolean online;
    
  /** default player has attributes "Name Unknown" and score 0 */
  public Player() {
   	this("unknown name",'U',0,0,0,"",false);
  }
  
  public Player(String name,char gender,int age,int score,double balance,String accNum,boolean online)
  {
  	super(name,gender,age);
  	setScore(score);
  	ba = new BankAccount(balance,accNum);
  	setOnline(online);
  }
  
  /** all attributes known
   *@param name Full Name
   *@param score Score
   */
  public Player(String name, int score){
  	setName(name);
  	setScore(score);
  }
  
  /** returns the player's full name */
  
  
  /** returns the player's current score */
  public int getScore() {
  	return score;
  }
  
 
  
  /** changes the score
   *@param score The new score, should be >= 0
   */
  public void setScore(int score){
  	if (score >=0)
  		this.score = score;
  }
  
  public boolean isOnline()
  {
  	return online;
  }
  
  public void setOnline(boolean online)
  {
  	this.online=online;
  }
  /** 
   *@return all attributes on one line separated by spaces */
  public String toString(){
  	return super.toString() + " " + getScore() + ba.toString()+ " Online: "+isOnline();
  }
  
  
    
    
}