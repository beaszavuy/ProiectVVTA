package AngajatiApp.controller;

import AngajatiApp.model.Employee;
import AngajatiApp.repository.EmployeeMock;
import AngajatiApp.repository.EmployeeRepositoryInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static AngajatiApp.controller.DidacticFunction.ASSISTENT;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeControllerTest {
    Employee employee;
    EmployeeController employeeController;
    EmployeeRepositoryInterface repo;
    @BeforeEach
    void setUp() {
        employee=new Employee();
        employee.setFirstName("Mihai");
        employee.setLastName("Ioana");
        employee.setCnp("2847398473623");
        employee.setFunction(ASSISTENT);
        employee.setSalary(4000.2);
        repo= new EmployeeMock();
        employeeController= new EmployeeController(repo);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addEmployee_TC1() {
        employee.setFirstName("Mihai");
        employee.setLastName("Ioana");
        employee.setCnp("2847398473623");
        employee.setFunction(ASSISTENT);
        employee.setSalary(4000.2);
        try{
            int nr_initial = employeeController.getEmployeesList().size();
            employeeController.addEmployee(employee);
            int nr_final=employeeController.getEmployeesList().size();
            assert (nr_final==nr_initial+1);
        }catch (Exception e){
            System.out.println("adas");
            assert (false);
        }
    }
    @Test
    void addEmployee_TC3() {
        employee.setFirstName("Mihai");
        employee.setLastName("Ioana");
        employee.setCnp("1321");
        employee.setFunction(ASSISTENT);
        employee.setSalary(4000.2);
        try{
            int nr_initial = employeeController.getEmployeesList().size();
            employeeController.addEmployee(employee);
            int nr_final=employeeController.getEmployeesList().size();
            assert (nr_final==nr_initial+1);
        }catch (Exception e){
            System.out.println("adas");
            assert (false);
        }
    }

    @Test
    void addEmployee_TC4() {
        employee.setFirstName("Mihai");
        employee.setLastName("Ioana");
        employee.setCnp("132231231231231231313121");
        employee.setFunction(ASSISTENT);
        employee.setSalary(4000.2);
        try{
            int nr_initial = employeeController.getEmployeesList().size();
            employeeController.addEmployee(employee);
            int nr_final=employeeController.getEmployeesList().size();
            assert (nr_final==nr_initial+1);
        }catch (Exception e){
            System.out.println("adas");
            assert (false);
        }
    }

    @Test
    void addEmployee_TC2() {
        employee.setFirstName("Mihai");
        employee.setLastName("Ioana");
        employee.setCnp("132231231231231231313121");
        employee.setFunction(ASSISTENT);
        employee.setSalary(-2.1);
        try{
            int nr_initial = employeeController.getEmployeesList().size();
            employeeController.addEmployee(employee);
            int nr_final=employeeController.getEmployeesList().size();
            assert (nr_final==nr_initial+1);
            employeeController.deleteEmplyess(employee.getId());
        }catch (Exception e){
            System.out.println("employee nu a fost adaugat cu succes");

        }
    }

    @Test
    void addEmployee_TC6() {
        employee.setFirstName("Mihai");
        employee.setLastName("Ioana");
        employee.setCnp("132231231231231231313121");
        employee.setFunction(null);
        employee.setSalary(-2.1);
        try{
            int nr_initial = employeeController.getEmployeesList().size();
            employeeController.addEmployee(employee);
            int nr_final=employeeController.getEmployeesList().size();
            assert (nr_final==nr_initial+1);
            employeeController.deleteEmplyess(employee.getId());
        }catch (Exception e){
            System.out.println("employee nu a fost adaugat cu succes");

        }
    }
}