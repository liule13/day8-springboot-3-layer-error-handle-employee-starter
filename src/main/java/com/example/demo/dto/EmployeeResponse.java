package com.example.demo.dto;

public class EmployeeResponse {
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private boolean state;

    public EmployeeResponse(Integer id, String name, Integer age, String gender, boolean state) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.state = state;
    }
    public EmployeeResponse() {}

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public boolean isState() {
        return state;
    }

    public void setId(Integer id) {
        this.id = id;
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
