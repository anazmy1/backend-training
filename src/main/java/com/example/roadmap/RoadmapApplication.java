package com.example.roadmap;

import com.example.roadmap.model.Department;
import com.example.roadmap.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class RoadmapApplication {

	public static void main(String[] args) {

		SpringApplication.run(RoadmapApplication.class, args);
		Department department = new Department("IT");
		Employee employee1 = new Employee("Ahmed", department);
		Employee employee2 = new Employee("David", department);
		department.addEmployees(Arrays.asList(employee1, employee2));
		department.removeEmployee(employee2);
		department.printEmployees();
	}

}
