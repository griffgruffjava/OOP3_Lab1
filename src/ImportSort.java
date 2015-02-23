import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

import javax.swing.JOptionPane;


public class ImportSort
{
	public static void main(String args[])
	{
		LinkedList<Player> myPlayers = new LinkedList<Player>();
		Player highestScore;
		String output="";
		
		try {
			ObjectInputStream is;
			is = new ObjectInputStream(new FileInputStream("allPlayers.dat"));
			myPlayers = (LinkedList<Player>) is.readObject();
			is.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Player test = new Player();
		highestScore = test;
		
		for(Player p:myPlayers)
		{
			output+=p.toString()+"\n";
			if(p.getScore()>highestScore.getScore())
			{
				highestScore=p;
			}
		}
		
		JOptionPane.showMessageDialog(null,highestScore.toString(),"Player with the highest Score",JOptionPane.INFORMATION_MESSAGE);	
		JOptionPane.showMessageDialog(null,output,"Player Details",JOptionPane.PLAIN_MESSAGE);
	}

}
