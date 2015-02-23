import java.io.Serializable;

/** models a bank account
 */
public class BankAccount implements Serializable{
	private String accNum;
	private double balance;
	
	public BankAccount()
	{
		this(0,"U");
	}
	
	public BankAccount(double balance,String accNum)
	{
		setBalance(balance);
		setAccNum(accNum);
	}
	
	public String getAccNum(){ return accNum;	}
	public double getBalance(){ return balance;	}
	
	/** set the account number
	 @param accNum the account number as a String
	 **/
	public void setAccNum(String accNum){
		this.accNum = accNum;
	}
	
	public void setBalance(double balance){
		this.balance=balance;
	}
	/** lodge any positive amount to the account
	 @param amount the amount to be lodged
	 */
	public void lodge(double amount){
	  if (amount >0)
		balance += amount;
	}
	
	/** withdraw anything up to the amount in the account
	 *@param amount the amount to be withdrawn
	 */
	public void withdraw(double amount){
		if (amount <=balance){
			balance -= amount;
		}
	}

	/** gives a String representation of the object
	 @return the class name as well as the account number and the balance
	 */
	public String toString() {
		return getClass() + " number: " + getAccNum() + " balance: " + getBalance();
	}
}