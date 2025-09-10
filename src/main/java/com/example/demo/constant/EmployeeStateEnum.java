package com.example.demo.constant;

import com.example.demo.entity.Employee;

public enum EmployeeStateEnum {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private final String state;

    EmployeeStateEnum(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
