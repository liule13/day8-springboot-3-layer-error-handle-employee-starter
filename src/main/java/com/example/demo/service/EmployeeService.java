package com.example.demo.service;

import com.example.demo.Exception.EmployeeException;
import com.example.demo.constant.EmployeeStateEnum;
import com.example.demo.entity.Employee;
import com.example.demo.respository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(String gender, Integer page, Integer size) {
        return employeeRepository.getEmployees(gender, page, size);
    }

    public Employee getEmployeeById(int id) {
        Employee employee = employeeRepository.getEmployeeById(id);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: " + id);
        }
        return employee;
    }

    public Employee createEmployee(Employee employee) {
        if (employee.getAge() == null) {
            throw new EmployeeException("Employee age cannot be null");
        }
        if (employee.getAge() > 65 || employee.getAge() < 18) {
            throw new EmployeeException("Employee age should be between 18 and 65");
        }
        if (employee.getAge()>=30&& employee.getSalary()<=20000) {
            throw new EmployeeException("Employee age is greater than 30, salary should be greater than 20000");
        }
        employee.setState(String.valueOf(EmployeeStateEnum.ACTIVE));
        return employeeRepository.createEmployee(employee);
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee employee = employeeRepository.getEmployeeById(id);
        if (employee == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: " + id);
        }
        return employeeRepository.updateEmployee(employee, updatedEmployee);
    }

    public void deleteEmployee(int id) {
        if (employeeRepository.getEmployeeById(id) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: " + id);
        }
        employeeRepository.deleteEmployee(id);
    }

    public void clear() {
        employeeRepository.clear();
    }
}
