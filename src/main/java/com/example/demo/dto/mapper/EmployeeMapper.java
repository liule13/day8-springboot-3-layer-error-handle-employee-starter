package com.example.demo.dto.mapper;

import com.example.demo.dto.EmployeeRequest;
import com.example.demo.dto.EmployeeResponse;
import com.example.demo.entity.Employee;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {
    public  EmployeeResponse toEmployeeResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        BeanUtils.copyProperties(employee, employeeResponse);
        return employeeResponse;
    }
    public List<EmployeeResponse> toEmployeeResponseList(List<Employee> employees) {
        return employees.stream().map(this::toEmployeeResponse).toList();
    }
//    public EmployeeRequest toEmployeeRequest(Employee employee) {
//        EmployeeRequest employeeRequest = new EmployeeRequest();
//        BeanUtils.copyProperties(employee, employeeRequest);
//        return employeeRequest;
//    }
//    public List<EmployeeRequest> toEmployeeRequestList(List<Employee> employees) {
//        return employees.stream().map(this::toEmployeeRequest).toList();
//    }
}
