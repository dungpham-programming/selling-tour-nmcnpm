package com.nmcnpm.model.impl;

import com.nmcnpm.model.abs.BaseUser;

public class Employee extends BaseUser {
    private String employeeBadge;
    private double salary;

    // Getters and Setters
    public String getEmployeeBadge() {
        return employeeBadge;
    }

    public void setEmployeeBadge(String employeeBadge) {
        this.employeeBadge = employeeBadge;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}