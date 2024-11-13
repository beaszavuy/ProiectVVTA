package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeMockTest {
    EmployeeMock employeeMock;

    @BeforeEach
    void setUp() {
        employeeMock = new EmployeeMock();
        // Add an employee with a specific ID and initial function
        employeeMock.addEmployee(new Employee(1, "Test Employee", DidacticFunction.ASSISTENT));
    }

    @AfterEach
    void tearDown() {
        // Clear the employee list after each test if needed (depends on EmployeeMock implementation)
        employeeMock.deleteEmployee(1);
    }

    @Test
    public void modifyEmployeeFunctiontest() {
        // Directly use the ID value 1
        Employee employee = employeeMock.findEmployeeById(1);
        assertNotNull(employee, "Employee should be found");

        // Modify the employee's function to LECTURER
        employeeMock.modifyEmployeeFunction(employee, DidacticFunction.LECTURER);

        // Verify the employee's function was updated
        assertEquals(DidacticFunction.LECTURER, employeeMock.findEmployeeById(1).getFunction(),
                "Employee function should be updated to LECTURER");
    }
    public void modifyEmployeeFunctiontest2() {
        // Directly use the ID value 1
        Employee employee = employeeMock.findEmployeeById(0);

        // Modify the employee's function to LECTURER
        employeeMock.modifyEmployeeFunction(employee, DidacticFunction.LECTURER);

        // Verify the employee's function was updated
        assertEquals(DidacticFunction.LECTURER, employeeMock.findEmployeeById(1).getFunction(),
                "Employee function should be updated to LECTURER");
    }
}