package com.example.demo.dto;

import com.example.demo.entity.Employee;

import java.util.List;

public class CompanyResponse {
    private Integer id;
    private String name;
    private boolean active;
    private List<Employee> employees;

    public CompanyResponse(Integer id, String name, boolean active, List<Employee> employees) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.employees = employees;
    }

    public CompanyResponse() {
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
