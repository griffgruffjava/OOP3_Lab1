import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Q1Driver
{
	public static void main(String args[])
	{
		Player p1; 
		boolean online=false;
		String output="";
		
		LinkedList<Player> myPlayers = new LinkedList<Player>();
		
		//public Player(String name,char gender,int age,int score,double balance,String accNum,boolean online)
		
		for(int i=0;i<2;i++)
		{
			String name = JOptionPane.showInputDialog("What is the players name?");
			char gender = (JOptionPane.showInputDialog("What is " + name +"'s gender(m or f)?")).charAt(0);
			int age = Integer.parseInt(JOptionPane.showInputDialog("What is " + name +"'s age?"));
			int score = Integer.parseInt(JOptionPane.showInputDialog("What is " + name +"'s score?"));
			double balance = Float.parseFloat(JOptionPane.showInputDialog("What is " + name +"'s bank balance?"));
			String accNum = JOptionPane.showInputDialog("What is " + name + "'s account number?");
			String onlineString = JOptionPane.showInputDialog("Is " +name+ " online(y or n)?"); 
			
			if(onlineString.equals("y"))
			{
				online=true;
				p1 = new Player(name,gender,age,score,balance,accNum,online);
			}
			else
			{
				online=false;
				p1 = new Player(name,gender,age,score,balance,accNum,online);
			}	
			
			myPlayers.add(p1);
			
		}
		
		for(Player p: myPlayers)
		{
			output+=p.toString()+"\n";	
		}
		
		JOptionPane.showMessageDialog(null,output,"Player Details",JOptionPane.PLAIN_MESSAGE);
		
//		File f1 = new File("allPlayers.dat");
//		FileOutputStream fos = new FileOutputStream(f1);
//		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
//		oos.writeObject(myPlayers);
//		oos.close();
		
		try {
			ObjectOutputStream os;
			os = new ObjectOutputStream(new FileOutputStream("allPlayers.dat"));
			os.writeObject(myPlayers);
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//end main
}//end class