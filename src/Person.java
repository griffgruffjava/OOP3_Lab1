/**Models a person, with name, age and gender */
public abstract class Person  {
	private String name;
	private char gender;
	private int age;
	
	//constructors
	
	
	
	public int getAge() { return age;}
	public char getGender() { return gender;}
	public String getName() { return name;}
	
	public void setAge (int age) {
				this.age = age;
	}
	
	/** change the name
	 *@param name Full Name
	 */
	public void setName( String name) {
				this.name = name;
	}
	
	/** assign the gender
	 *@param g Gender: 'm' or 'f'
	 */
	public void setGender(char gender) {
				this.gender = gender;
	}
	
	/** default Persons have attributes "Name Not Given,", 0 and 'U'*/
	public Person() {
				this("Name Not Given",'U',0);
	}
	
	/** all attributes known
	 *@param name Full name
	 *@param age Age to the nearest year
	 *@param gender Gender 'm' or 'f'
	 */
	public Person(String name, char gender, int age) {
				setName(name);
				setAge(age);
				setGender(gender);
	}
	
	/** returns all attributes on one line, separated by spaces*/
	public String toString() {
				return getName() + " " + getAge() + " " + getGender();
	}
}