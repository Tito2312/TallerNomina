package nominaEmpresarial;

import java.util.ArrayList;

public class Company {
	private String name = "EMPRESA DE TITO";
	private ArrayList<Employee> employeeList;
	
	public Company(String name) {
		this.name = name;
		this.employeeList = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee employee) {
		this.employeeList.add(employee);
	}
	
	public Employee getEmployee(String name) {
		
		for (Employee employee : this.employeeList) {
			if(employee.getName().equalsIgnoreCase(name)) {
				return employee;
			}
		}
		
		return null;
	}
	
	public void deleteEmployee(Employee employee) {
		this.employeeList.remove(employee);
		
	}
	
	public void updateEmployee(Employee e, String name, int age, double salary, ArrayList<Double> commissios) {
		e.setName(name);
		e.setAge(age);
		e.setSalary(salary);
		e.setCommissions(commissios);
	}
	
	
	public double calculateTotalPayroll() {
		double totalPayroll = 0;
		for (Employee employee : this.employeeList) {
			totalPayroll+= employee.calculateTotalSalary();
		}
		
		return totalPayroll;
	}
	
	public Employee getEmployeeWithBestSalary() {
		Employee bestSalary = this.employeeList.getFirst();
		
		for (Employee employee : this.employeeList) {
			if (employee.calculateTotalSalary() >= bestSalary.calculateTotalSalary()) {
				bestSalary = employee;
			}
		}
		return bestSalary;
		
	}
	
	public Employee getEmployeeWithBestCommissions() {
		Employee bestCommissions = this.employeeList.getFirst();
		
		for (Employee employee : this.employeeList) {
			if (employee.calculateTotalSalary() >= bestCommissions.calculateTotalSalary()) {
				bestCommissions = employee;
			}
		}
		return bestCommissions;
	}
	
	public double calculateAverageSalary() {
		double salaries = 0;
		double average = 0;
		for (Employee employee : employeeList) {
			salaries+=employee.calculateTotalSalary();
		}
		average = salaries /(this.employeeList.size());
		return average;
	}
	
	public ArrayList<Employee> listEmployeesBySalaryRange(double minSalary, double maxSalary){
		ArrayList<Employee> rangeEmployeesList = new ArrayList<>();
		for (Employee employee : this.employeeList) {
			if(employee.calculateTotalSalary()>minSalary && employee.calculateTotalSalary()<maxSalary) {
				rangeEmployeesList.add(employee);
			}
		}
		return rangeEmployeesList;
	}
	
	public ArrayList<Employee> listEmployeesByDeparment(){
		
		return null;
	}
	
	public Deparment getDeparmentWithMoreEmployees() {
		
		
		return null;
	}
	
	public Employee getEmployeeWithPoyect() {
		return null;
		
	}
	
	public Proyect getLongerProyect() {
		return null;
		
	}
	
	public double getAveragePoryects() {
		return 0;
		
	}

	@Override
	public String toString() {
		return "Lista de empleados:" + employeeList;
		
	}
	
	
}
