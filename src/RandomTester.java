
public class RandomTester
{
	public static void main(String args[])
	{
		int num;
		for(int i=0;i<=100;i++)
		{
			num = (int)(Math.random()*100+1);
			System.out.println(num);
		}
		
	}
}
