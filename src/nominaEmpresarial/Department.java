package nominaEmpresarial;

import java.util.ArrayList;

public class Department {
	private String name;
	private ArrayList<Employee> employeeList;
	
	
	
	public void addEmployee(Employee employee) {
		this.employeeList.add(employee);
	}
	
	public double calculateSalaryExpense() {
		double SalaryExpense = 0;
		for (Employee employee : this.employeeList) {
			SalaryExpense+= employee.calculateTotalSalary();
		}
		
		return SalaryExpense;
	}
	
	public int EmployeesNumber() {
		return employeeList.size();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Deparment [name=" + name + ", employeeList=" + employeeList + "]";
	}
	
	
	
}
