package com.example.roadmap.model;


import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Department {
    private String name;
    private ArrayList<Employee> employeesList;

    private String fileName;

    public Department(String name) {
        this.name = name;
        this.fileName = "employees.txt";
        employeesList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeesList() {
        return employeesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployeesList(ArrayList<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    public void addEmployees(Collection<Employee> employees) {
        this.employeesList.addAll(employees);
        this.writeEmployees(employees);
    }

    public void removeEmployee(Employee employee) {
        int employeeIndex = employeesList.indexOf(employee);
        this.employeesList.remove(employeeIndex);
        this.removeEmployeeFromFile(employeeIndex);
    }

    public void printEmployees() {
        employeesList.forEach(employee -> System.out.println(employee.toString()));
    }

    private void writeEmployees(Collection<Employee> employees) {
        try {
            FileWriter file = new FileWriter(this.fileName);
            for (Employee employee : employees) {
                file.append(employee.toString());
                file.append("\n");
            }
            file.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    private void removeEmployeeFromFile(int index) {
        try {
            File file = new File(fileName);
            Scanner reader = new Scanner(file);

            File tempFile = new File("temp.txt");
            FileWriter writer = new FileWriter("temp.txt", false);
            int currentIndex = 0;

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if(currentIndex != index)
                    writer.write( line );
                 currentIndex += 1;
            }
            writer.close();
            tempFile.renameTo(file);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}