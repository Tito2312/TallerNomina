package nominaEmpresarial;

import java.util.ArrayList;

public class Company {
	private String name = "EMPRESA DE TITO";
	private ArrayList<Employee> employeeList;
	private ArrayList<Department> departmentList;
	private ArrayList<Proyect> proyectList;
	
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
	
	public ArrayList<Department> getDepartments(){
		return this.departmentList;
	}
	
	public void addDepartment(Department department) {
		this.departmentList.add(department);
	}
	
	public Department getDepartment(String name) {
		for (Department departamento : this.departmentList) {
			if(departamento.getName().equalsIgnoreCase(name)) {
				return departamento;
			}
		}
		return null;
	}
	
	public void updateDepartment(Department department, String name) {
		department.setName(name);
	}
	
	public void deleteDepartment(Department department) {
		this.departmentList.remove(department);
	}
	
	public ArrayList<Employee> listEmployeesByDeparment(Department department){
		ArrayList<Employee> DepartmentEmployeesList = new ArrayList<>();
		for (Employee employee : this.employeeList) {
			DepartmentEmployeesList.add(employee);
		}
		return DepartmentEmployeesList;
	}
	
	public Department getDeparmentWithMoreEmployees() {
		Department deparmentWithMoreEmployees = this.departmentList.get(0);
		for (Department department : this.departmentList) {
			if(department.EmployeesNumber()>deparmentWithMoreEmployees.EmployeesNumber()) {
				deparmentWithMoreEmployees = department;
			}
		}
		return deparmentWithMoreEmployees;
	}
	
	public ArrayList<Department> getProyects(){
		return this.departmentList;
	}
	
	public void addProyects(Department department) {
		this.departmentList.add(department);
	}
	
	public Proyect getProyect(String name) {
		for (Proyect proyect : this.proyectList) {
			if(proyect.getName().equalsIgnoreCase(name)) {
				return proyect;
			}
		}
		return null;
	}
	
	public void updateProyect(Proyect proyect, String name, Employee responsible, int duration, double cost) {
		proyect.setName(name);
		proyect.setResponsible(responsible);
		proyect.setDuration(duration);
		proyect.setCost(cost);
	}
	
	public void deleteProyect(Proyect proyect) {
		this.proyectList.remove(proyect);
	}
	
	public ArrayList<Employee> listaEmpleadosPorProyecto(Proyect proyect) {
		return proyect.getEmployeeList();
	}
	
	public Proyect getLongerProyect() {
		Proyect longerProyect = this.proyectList.get(0);
		for (Proyect proyect : this.proyectList) {
			if(proyect.getDuration()>longerProyect.getDuration()) {
				longerProyect = proyect;
			}
		}
		return longerProyect;
		
	}
	
	public double getAveragePoryects() {
		double costProyect = 0;
		for (Proyect proyect : this.proyectList) {
			costProyect+=proyect.getCost();
		}
		return costProyect/this.proyectList.size();
		
	}

	@Override
	public String toString() {
		return "Lista de empleados:" + employeeList;
		
	}
	
	
}
