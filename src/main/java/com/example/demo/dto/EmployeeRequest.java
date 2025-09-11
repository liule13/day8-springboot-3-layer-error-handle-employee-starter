package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;

public class EmployeeRequest {
    private String name;
    private Integer age;
    @NotNull(message = "Gender cannot be null")
    private String gender;
    private Double salary;
    private boolean state;

    public EmployeeRequest(String name, Integer age, String gender, boolean state) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.state = state;
    }
    public EmployeeRequest() {}

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public boolean isState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
