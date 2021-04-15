
public class SalariedEmployees extends Employees {

	private double Salary;
	private double Extras;
	private String Job;
	
	public SalariedEmployees(String name, String surname, int age, double salary, double extras, String username, String password, String email, String job) {
		super(name, surname, age, username, password, email);
		Salary = salary;
		Extras = extras;		
		Job = job;
	}

	//Υπολογισμός μισθού
	public double CalculateSalary() {
		
		return Salary + Extras;
	}

}
