package com.example.demo.service;

import com.example.demo.Exception.EmployeeException;
import com.example.demo.entity.Employee;
import com.example.demo.respository.IEmployeeRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //    getEmployeeByGender
    public List<Employee> getEmployeeByGender(String gender, Integer page, Integer size) {
        if (gender == null) {
            if (page == null || size == null) {
                return employeeRepository.findAll();
            } else {
                Pageable pageable = PageRequest.of(page-1, size);
                return employeeRepository.findAll(pageable).toList();
            }
        } else {
            if (page == null || size == null) {
                return employeeRepository.findEmployeeByGender(gender);
            } else {
                Pageable pageable = PageRequest.of(page - 1, size);
                return employeeRepository.findEmployeeByGender(gender, pageable);
            }
        }
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found with id: " + id);
        }
        return employee.get();
    }

    public Employee createEmployee(Employee employee) {
        if (employee.getAge() == null) {
            throw new EmployeeException("Employee age cannot be null");
        }
        if (employee.getAge() > 65 || employee.getAge() < 18) {
            throw new EmployeeException("Employee age should be between 18 and 65");
        }
        if (employee.getAge() >= 30 && employee.getSalary() <= 20000) {
            throw new EmployeeException("Employee age is greater than 30, salary should be greater than 20000");
        }
        employee.setState(true);
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee updatedEmployee) {
        Employee employee = getEmployeeById(id);

        if (!employee.getState()) {
            throw new EmployeeException("Cannot update inactive employee with id: " + id);
        }
        updatedEmployee.setId(id);
        return employeeRepository.save(updatedEmployee);
    }

    public void deleteEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employee.setState(false);
        employeeRepository.save(employee);
    }
}
