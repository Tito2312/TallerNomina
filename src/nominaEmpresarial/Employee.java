package nominaEmpresarial;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Employee {
	//EMPLOYEE ATTRIBUTES
	private String name;
	private String age;
	private double salary;
	private ArrayList<Double> commissions;
	
	//EMPLOYEE METHODS
	
	//ADD COMMISSIONS TO CALCULATE TOTALSALARY
	public void addComissions() {
		int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantas comisiones tiene el empleado este mes"));
		double commision;
		
		for (int i = 0; i < quantity; i++) {
			commision = Double.parseDouble(JOptionPane.showInputDialog(null, "Ingrese el valor de la comision numero "+ i));
			this.commissions.add(commision);
		}
	}
	
	//CALCULATING TOTAL SALARY (commissions + base salary)
	public double calculateTotalSalary() {
		addComissions();
		double newSalary = 0;
		
		for (int i = 0; i < this.commissions.size(); i++) {
			newSalary += commissions.get(i);
		}
		newSalary += this.salary;
		
		return newSalary;
	}
}
