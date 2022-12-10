package com.example.roadmap.model;

import java.io.File;

public class Employee {
    private String name;
    private  Department department;


    public Employee(String name, Department department){
        this.name = name;
        this.department =  department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department=" + department.getName() +
                '}';
    }

    public void print(){
        System.out.println(this.toString());
    }
}
