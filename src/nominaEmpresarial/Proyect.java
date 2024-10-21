package nominaEmpresarial;

import java.util.ArrayList;

public class Proyect {
	
	private String name;
	private Employee responsible;
	private int duration;
	private double cost;
	private ArrayList<Employee> employeeList;
	
	public Proyect(String name, Employee responsible, int duration, double cost) {
		super();
		this.name = name;
		this.responsible = responsible;
		this.duration = duration;
		this.cost = cost;
		this.employeeList = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		this.employeeList.add(employee);
	}
	
	public void assignResponsible(Employee employee) {
		this.responsible = employee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getResponsible() {
		return responsible;
	}

	public void setResponsible(Employee responsible) {
		this.responsible = responsible;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public ArrayList<Employee> getEmployeeList() {
		return employeeList;
	}
	
	public void setEmployeeList(ArrayList<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	@Override
	public String toString() {
		return "Proyect [name=" + name + ", responsible=" + responsible + ", duration=" + duration + ", cost=" + cost
				+ ", employeeList=" + employeeList + "]";
	}

	
	
	
}
