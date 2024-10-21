package nominaEmpresarial;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Employee {
	//EMPLOYEE ATTRIBUTES
	private String name;
	private int age;
	private double salary;
	private ArrayList<Double> commissions;
	
	//EMPLOYEE METHODS
	
	public Employee(String name, int age, double salary, ArrayList<Double> comisiones) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.commissions = comisiones;
	}
	
	//ADD COMMISSIONS TO CALCULATE TOTALSALARY
	@SuppressWarnings("null")
	public ArrayList<Double> addComissions() {
		int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantas comisiones tiene al empleado?"));
		double commision;
		ArrayList<Double> Ecommissions = new ArrayList<Double>();
		
		for (int i = 0; i < quantity; i++) {
			
			commision = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de la comision numero "+ (i+1)));
			Ecommissions.add(commision);
		}
		
		return Ecommissions;
	}
	
	//CALCULATING TOTAL SALARY (commissions + base salary)
	public double calculateTotalSalary() {
		//double totalCommisions = 0;
		double newSalary = 0;
		
		for (int i = 0; i < this.commissions.size(); i++) {
			newSalary += this.commissions.get(i);
		}
		newSalary += this.salary;
		
		return newSalary;
	}
	
	//SETTERS AND GETTERS
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public ArrayList<Double> getCommissions() {
		return commissions;
	}

	public void setCommissions(ArrayList<Double> commissions) {
		this.commissions = commissions;
	}
	
	//toString
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", commissions=" + commissions + "]";
	}
}
