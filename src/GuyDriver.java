import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class GuyDriver extends JFrame implements ActionListener  
{
	
	private JButton GoodShootsBad;
	private JButton BadShootsGood;
	private Container cpane;
	private BadGuy badguy;
	private GoodGuy goodguy;
	private JTextArea goodLabel;
	private JTextArea badLabel;
	
	public GuyDriver(){
		setTitle("Game");
		setSize(300,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JButton GoodShootsBad = new JButton("Shoot Bad!");
		GoodShootsBad.addActionListener(this);
   		JButton BadShootsGood = new JButton("Shoot Good!");
   		BadShootsGood.addActionListener(this);
   		
   		badguy = new BadGuy();
		goodguy = new GoodGuy();
   		
   		//JTextArea textArea = new JTextArea(50,125);
   		Container cpane=getContentPane();
		cpane.setLayout(new FlowLayout());
		cpane.add(GoodShootsBad);
		cpane.add(BadShootsGood);
		goodLabel = new JTextArea(goodguy.toString());
		cpane.add(goodLabel);
		badLabel = new JTextArea(badguy.toString());
		cpane.add(badLabel);
		
		
		
	
		
	} // end constructor
	
	
	
	
	
	public static void main(String args[])
	{
		GuyDriver gd = new GuyDriver();
   		gd.setVisible(true);
   		
   			
	}// end main
	
	public void actionPerformed(ActionEvent e)
	{
		//if (e.getSource()==GoodShootsBad){
		if (e.getActionCommand().equals("Shoot Bad!"))
		{	
			if(goodguy.getAmmo()>0)
			{
				shootOpponent(badguy);
					
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Sorry, the Good Guy has no bullets left!");
			}
		}
		else if (e.getActionCommand().equals("Shoot Good!"))
		{
			if(badguy.getAmmo()>0)
			{
				shootOpponent(goodguy);
					
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Sorry, the Bad Guy has no bullets left!");
			}
			
			
		}
		
	}
		
	public void shootOpponent(GunSlinger g)
	{
		int num = num = (int)(Math.random()*100+1);
		
		if(g instanceof GoodGuy)
		{
			badguy.setAmmo(badguy.getAmmo()-1);
			
			if(num%2==0)
			{
				JOptionPane.showMessageDialog(null,"Oh no! The Shooter Misses!");
			}
			else
			{
				goodguy.setStrength(goodguy.getStrength()-num);
				if(goodguy.getStrength()<=0)
				{
					JOptionPane.showMessageDialog(null, "Got him! You have killed the Good Guy");
					goodguy.setAlive(false);
					System.exit(0);
				}
			}
		}
		else
		{
			goodguy.setAmmo(goodguy.getAmmo()-1);
		
			if(num%2==0)
			{
				JOptionPane.showMessageDialog(null,"Shooter Misses!");
			}
			else
			{
				badguy.setStrength(badguy.getStrength()-num);
				if(badguy.getStrength()<=0)
				{
					JOptionPane.showMessageDialog(null, "Got him, You have killed the Bad Guy");
					badguy.setAlive(false);
					System.exit(0);
				}
					
			}
		}
		
		goodLabel.replaceRange(goodguy.toString(), 0, goodguy.toString().length());
		badLabel.replaceRange(badguy.toString(), 0, badguy.toString().length());
		
	}
	
}