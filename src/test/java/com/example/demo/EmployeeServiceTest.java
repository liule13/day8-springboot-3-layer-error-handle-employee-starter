package com.example.demo;

import com.example.demo.Exception.EmployeeException;
import com.example.demo.entity.Employee;
import com.example.demo.respository.IEmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;
    @Mock
    private IEmployeeRepository employeeRepository;

    @Test
    void should_throw_exception_when_create_employee() {
        Employee employee = new Employee(null, "John Smith", 20, "MALE", 60000.0);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee employeeResult = employeeService.createEmployee(employee);
        assertEquals(employee.getName(), employeeResult.getName());
    }

    @Test
    void should_throw_exception_when_create_employee_of_greater_than_65_and_less_than_18() {
        Employee employee = new Employee(null, "Leo Smith", 70, "MALE", 60000.0);
        assertThrows(EmployeeException.class, () -> employeeService.createEmployee(employee));

    }

    @Test
    void should_throw_exception_when_create_employee_of_greater_than_30_and_salary_less_than_18() {
        Employee employee = new Employee(null, "Leo Smith", 31, "MALE", 10000.0);
        assertThrows(EmployeeException.class, () -> employeeService.createEmployee(employee));
    }

    @Test
    void should_set_state_active_when_create_employee() {
        Employee employee = new Employee(null, "Leo Smith", 20, "MALE", 10000.0);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee employeeResult = employeeService.createEmployee(employee);
        assertTrue(employeeResult.getActive());
    }

    @Test
    void should_throw_exception_when_update_inactive_employee() {
        Employee employee = new Employee(null, "Leo Smith", 20, "MALE", 10000.0);
        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);
        Employee employeeResult = employeeService.createEmployee(employee);
        employeeResult.setId(1);
        employee.setActive(false);
        assertThrows(ResponseStatusException.class, () -> employeeService.updateEmployee(employeeResult.getId(), employee));
    }

}
