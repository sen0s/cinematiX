import java.util.ArrayList;

import javax.swing.JOptionPane;

public abstract class Employees {
	private String Name;
	private String Surname;
	private int Age;
	private String Username;
	private String Password;
	private String Email;
	private ArrayList<Employees> Members;
	private ArrayList<String> Usernames;
	
	
	public Employees(String name, String surname, int age, String username, String password, String email)
	{
		Name = name;
		Surname = surname;
		Age = age;
		Username = username;
		Password = password;
		Email = email;
		Members = new ArrayList<Employees>();
		Usernames = new ArrayList<String>();
		
		if(email.endsWith("@gmail.com") || email.endsWith("@yahoo.com"))
			Email = email;
		else
			JOptionPane.showMessageDialog(null, "New member has not created. Please check the Email format");
	}
	
	abstract public double CalculateSalary();
	
 
	public void Verify()
	{
		
		
	}
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
	
	   Username = username;
		
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public ArrayList<Employees> getMembers() {
		return Members;
	}

	public void setMembers(ArrayList<Employees> members) {
		Members = members;
	}

	public ArrayList<String> getUsernames() {
		return Usernames;
	}

	public void setUsernames(ArrayList<String> usernames) {
		Usernames = usernames;
	}

	
}
