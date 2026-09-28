package com.test.dcplicate1;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

public class SecondHighestSalary {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
            new Employee(101, "Ravi", "IT", 80000),
            new Employee(102, "Kiran", "IT", 90000),
            new Employee(103, "Raj", "IT", 100000),
            new Employee(104, "Suresh", "HR", 60000),
            new Employee(105, "Arun", "HR", 70000),
            new Employee(106, "John", "HR", 80000),
            new Employee(107, "David", "Finance", 50000),
            new Employee(108, "Peter", "Finance", 70000)
        );

        Map<String, Optional<Double>> result =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.mapping(
                                        Employee::getSalary,
                                        Collectors.collectingAndThen(
                                                Collectors.toSet(),
                                                salaries -> salaries.stream()
                                                        .sorted(Comparator.reverseOrder())
                                                        .skip(1)
                                                        .findFirst()
                                        )
                                )
                        ));

        result.forEach((department, salary) ->
                System.out.println(department + " : " + salary.orElse(null)));
    }
}
