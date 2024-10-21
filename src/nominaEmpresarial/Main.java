package nominaEmpresarial;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	
	public static Company company = new Company("TITO SAS");
	
	public static void main(String[] args) {
		
		int option = 0;
		String menu = menu();
		
		do {
			option = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
			if (option >= 1 && option <= 2) {
				int opcSubMenu = Integer.parseInt(JOptionPane.showInputDialog(null, getSubMenu(option)));
				optionsSubMenu(option, opcSubMenu);
			}
		} while(option != 5);
	}
	
	// MENUS 
	private static String menu() {
		String menu = "Ingrese una opcion:\n"
				+ "1. Empleados.\n"
				+ "2. Departamentos.\n"
				+ "3. Proyectos.\n"
				+ "4. Funcionalidades.\n"
				+ "5. Salir.";
		return menu;
	}
	
	private static String getSubMenu(int menu) {
		String subMenu = "Ingrese una opcion:\n";
		switch (menu) {
		case 1:
			subMenu += "1. Lista de empleados.\n"
					+ "2. Agregar empleado.\n"
					+ "3. Actualizar empleado.\n"
					+ "4. Eliminar empleado.\n"
					+ "5. Volver";
			break;
		case 2:
			subMenu += "1. Lista de departamentos.\n"
					+ "2. Agregar departamento.\n"
					+ "3. Actualizar departamento.\n"
					+ "4. Eliminar departamento.\n"
					+ "5. Listar empleados por departamento.\n"
					+ "6. Agregar empleado a departamento.\n"
					+ "7. Volver";
			break;
		case 3:
			subMenu += "1. Lista de proyectos.\n"
					+ "2. Agregar proyecto.\n"
					+ "3. Actualizar proyecto.\n"
					+ "4. Eliminar proyecto.\n"
					+ "5. Listar empleados por proyecto.\n"
					+ "6. Agregar empleado a proyecto.\n"
					+ "7. Volver";
			break;
		case 4:
			subMenu += "1. Calcular nomina total.\n"
					+ "2. Empleado con mejor sueldo.\n"
					+ "3. Empleado con mas comisiones.\n"
					+ "4. Promedio de salarios.\n"
					+ "5. Listar empleados por rango de salario.\n"
					+ "6. Departamento con mas empleados.\n"
					+ "7. Proyecto mas largo.\n"
					+ "8. Promedio de costo de proyectos.\n"
					+ "9. Volver.";
			break;
		default:
			break;
		}
		return subMenu;
	}
	
	private static void optionsSubMenu(int opcion, int subMenu) {
		switch (opcion) {
		case 1:
			EmployeesOptions(subMenu);
			break;
		case 2:
			functionsOptions(subMenu);
			break;
		default:
			break;
		}
	}
	
	
	public static void EmployeesOptions(int subMenu) {
		switch (subMenu) {
		case 1:
			EmployeesList();
			break;
		case 2:
			addEmployee();
			break;
		case 3:
			updateEmployee();
			break;
		case 4:
			deleteEmployee();
			break;
		default:
			break;
		}
	}
	
	public static void functionsOptions(int subMenu) {
		switch (subMenu) {
		case 1:
			calculateTotalPayroll();
			break;
		case 2:
			getEmployeeWithBestSalary();
			break;
		case 3:
			getEmployeeWithBestCommissions();
			break;
		case 4:
			calculateAverageSalary();
			break;
		case 5:
			listEmployeesBySalaryRange();
			
			break;
		default:
			break;
		}
	}
	
	public static void ProyectsOptions(int subMenu) {
		switch (subMenu) {
		case 1:
			getProyects();
			break;
		case 2:
			addProyects();
			break;
		case 3:
			updateProyect();
			break;
		case 4:
			deleteProyect();
			break;
		case 5:
			ListEmployeesWithProyect();
			break;
		case 6:
			addEmployeeInProyect();
			break;
		default:
			break;
		}
	}
	//METHODS
	public static void EmployeesList() {
		System.out.println(company.toString());
	}
	
	public static void addEmployee() {
		
		String name = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
		int age = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del empleado: "));
		double baseSalary = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario base del empleado: "));
		
		Employee e1 = new Employee(name, age, baseSalary, null);
		ArrayList<Double> commissions = e1.addComissions();
		e1.setCommissions(commissions);
		
		company.addEmployee(e1);
	}
	
	public static void updateEmployee() {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
		
		Employee e1 = company.getEmployee(name);
		
		if(e1 != null) {
			name = JOptionPane.showInputDialog("Ingrese el nombre: ");
			int age = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad: "));
			double baseSalary = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario base: "));
			ArrayList<Double> comisiones = e1.addComissions();
			
			company.updateEmployee(e1, name, age, baseSalary, comisiones);
			JOptionPane.showMessageDialog(null, "Empleado actualizado");
		} else {
			JOptionPane.showMessageDialog(null, "El empleado no existe");
		}
	}
	
	public static void deleteEmployee() {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
		
		Employee e1 = company.getEmployee(name);
		
		if(e1 != null) {
			company.deleteEmployee(e1);
			JOptionPane.showMessageDialog(null, "Empleado eliminado con exito");
		} else {
			JOptionPane.showMessageDialog(null, "El empleado no existe");
		}
	}
	
	public static void calculateTotalPayroll() {
		JOptionPane.showMessageDialog(null, "La nomina total de la empresa es igual a: " + company.calculateTotalPayroll());
	}
	public static void getEmployeeWithBestSalary() {
		JOptionPane.showMessageDialog(null, "El empleado con mejor salario es: " + company.getEmployeeWithBestSalary().getName());
	}
	public static void getEmployeeWithBestCommissions() {
		JOptionPane.showMessageDialog(null, "El empleado con mejores comisiones es: " + company.getEmployeeWithBestCommissions().getName());
	}
	public static void calculateAverageSalary() {
		JOptionPane.showMessageDialog(null, "el promedio salarial de la empresa es igual a: " + company.calculateAverageSalary());
	}
	public static void listEmployeesBySalaryRange() {
		
		double minSalary = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario minimo del rango a buscar: "));
		double maxSalary = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario minimo del rango a buscar: "));
		
		String msg = "La nomina total de la empresa es igual a: " + company.listEmployeesBySalaryRange(minSalary, maxSalary);
		
		JOptionPane.showMessageDialog(null, msg);
	}
	
	////////////////////
	public static void getProyects() {
		System.out.println(company.getProyects().toString());
	}
	
	public static void addProyects() {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del proyecto: ");
		int duration = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duracion en meses: "));
		double cost = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo: "));
		String responsible = JOptionPane.showInputDialog("Ingrese el nombre del responsable del proyecto: ");
		Employee employee = company.getEmployee(responsible);
		
		if(employee != null) {
			Proyect p = new Proyect(name, employee, duration, cost);
	        company.addProyect(null);
			JOptionPane.showMessageDialog(null, "Proyecto agregado");
		} else {
			JOptionPane.showMessageDialog(null, "El responsable no existe");
		}
	}
	
	public static void updateProyect() {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del proyecto: ");
		Proyect proyect = company.getProyect(name);
		
		if(proyect != null) {
			String nameP = JOptionPane.showInputDialog("Ingrese el nombre del proyecto: ");
			int duration = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la duracion en meses: "));
			double cost = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el costo: "));
			String responsible = JOptionPane.showInputDialog("Ingrese el nombre del responsable del proyecto: ");
			Employee employee = company.getEmployee(responsible);
			
			if(employee != null) {
				company.updateProyect(proyect, name, employee, duration, cost);
				JOptionPane.showMessageDialog(null, "Proyecto actualizado");
			} else {
				JOptionPane.showMessageDialog(null, "El responsable no existe");
			}
		} else {
			JOptionPane.showMessageDialog(null, "El proyecto no existe");
		}
	}
	
	public static void deleteProyect() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del proyecto:");
		Proyect proyect = company.getProyect(nombre);
		
		if(proyect != null) {
			company.deleteProyect(proyect);
			JOptionPane.showMessageDialog(null, "Proyecto eliminado con exito");
		} else {
			JOptionPane.showMessageDialog(null, "El proyecto no existe");
		}
	}
	
	public static void ListEmployeesWithProyect() {
		String name = JOptionPane.showInputDialog("Ingrese el nombre del proyecto:");
		Proyect proyect = company.getProyect(name);
		
		if(proyect != null) {
			String nameE = JOptionPane.showInputDialog("Ingrese el nombre del empleado: ");
			Employee employee = company.getEmployee(nameE);
			
			if(employee != null) {
				company.addEmployeeinProyect(proyect, employee);
				JOptionPane.showMessageDialog(null, "Empleado agregado con exito");
			} else {
				JOptionPane.showMessageDialog(null, "El empleado no existe");
			}
		} else {
			JOptionPane.showMessageDialog(null, "El proyecto no existe");
		}
	}
	
	public static void addEmployeeInProyect() {
		String nameP = JOptionPane.showInputDialog("Ingrese el nombre del proyecto:");
		Proyect proyect = company.getProyect(nameP);
		
		if(proyect != null) {
			System.out.println(company.ListEmployeesWithProyect(proyect).toString());
			JOptionPane.showMessageDialog(null, "Departamento: "+nameP+"\n"+company.ListEmployeesWithProyect(proyect).toString());
		} else {
			JOptionPane.showMessageDialog(null, "El proyecto no existe");
		}
	}
	
}
