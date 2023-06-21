package com.ms.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

record Employee(int id, String name, double salary, Department department){
    public String getDepartmentName(){
        return this.department.name();
    }
}
record Department(int id, String name){}

public class CollectorsExample {

    static List<Employee> employees = List.of(
            new Employee(1,"Alex", 100d, new Department(1, "HR")),
            new Employee(2,"Brian", 200d, new Department(1, "HR")),
            new Employee(3,"Charles", 900d, new Department(2, "Finance")),
            new Employee(4,"David", 200d, new Department(2, "Finance")),
            new Employee(5,"Edward", 200d, new Department(3, "Finance")),
            new Employee(6,"Frank", 800d, new Department(2, "Admin")),
            new Employee(7,"George", 900d, new Department(2, "Admin"))

    );

    public static void main(String[] args) {
        //group all employees by department
        Map<String, List<String>> empByDeptName = employees.stream()
                .collect(groupingBy(Employee::getDepartmentName,
                        mapping(Employee::name, toList())));
        System.out.println("empByDeptName = " + empByDeptName);
        
        //count all employees in department
        Map<String, Long> empCountByDept = employees.stream()
                .collect(groupingBy(Employee::getDepartmentName,
                        counting()));
        System.out.println("empCountByDept = " + empCountByDept);

        //get all the employees having same salary
        Map<Double, List<String>> empWithSameSalary = employees.stream()
                .collect(groupingBy(Employee::salary,
                        mapping(Employee::name, toList())));
        System.out.println("empWithSameSalary = " + empWithSameSalary);

        //get avg salary in each department
        Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(groupingBy(Employee::getDepartmentName,
                        averagingDouble(Employee::salary)));
        System.out.println("avgSalaryByDept = " + avgSalaryByDept);

        //get maximum salaried person in each department
        Map<String, Optional<Employee>> maxSalaryByDept = employees.stream()
                .collect(groupingBy(Employee::getDepartmentName,
                        maxBy(Comparator.comparingDouble(Employee::salary))));
        System.out.println("maxSalaryByDept = " + maxSalaryByDept);

        //get minimum salaried person in each department
        Map<String, Optional<Employee>> minSalaryByDept = employees.stream()
                .collect(groupingBy(Employee::getDepartmentName,
                        minBy(Comparator.comparingDouble(Employee::salary))));
        System.out.println("minSalaryByDept = " + minSalaryByDept);

    }
}
