package Tests;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import nominaEmpresarial.Company;
import nominaEmpresarial.Employee;

class Tests{

	@Test
    public void datosCompletos() {
        Employee empleado = new Employee("Paco", 19, 1000);

        assertAll("Empleado",
        () -> assertEquals("Paco", empleado.getName()),
        () -> assertEquals(19, empleado.getAge()),
        () -> assertEquals(1000, empleado.getSalary())
        );
    }
	

	@Test
    public void datosVacios() {
        
	Employee empleado1 = new Employee("Paco", 19, 1000);
        assertThrows(Throwable.class, () -> new Employee("", 0, 0));
        
    }
	@Test
    public void agregarEmpleado() {
    	Company empresa = new Company("HP");
    	Employee empleado = new Employee("Paco", 19, 1000);
    	
    	empresa.addEmployee(empleado);
    	assertTrue(empresa.ListEmployees().contains(empleado));
    }
	@Test
    void eliminarEmpleado() {
    	Company empresa = new Company("HP");
    	Employee empleado1 = new Employee("Paco", 19, 1000);
    	Employee empleado2 = new Employee("Pedro", 29, 2000);
    	empresa.addEmployee(empleado1);
    	empresa.addEmployee(empleado2);
    	
    	empresa.deleteEmployee(empleado1);
    	
    	assertFalse(empresa.ListEmployees().contains(empleado1));
    	assertEquals(1, empresa.ListEmployees().size());
    }

}
