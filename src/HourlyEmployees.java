
public class HourlyEmployees extends Employees {

	private double Wage;
	private int Hours;
	private String Job;
	
	public HourlyEmployees(String name, String surname, int age,  double wage, int hours, String username, String password, String email, String job) {
		super(name, surname, age, username, password, email);
		Wage = wage;
		Hours = hours;
		Job = job;
	}
	
	// Υπολογισμός μισθού
		public double CalculateSalary()
		{			
			return Wage*Hours;
		}	

}
