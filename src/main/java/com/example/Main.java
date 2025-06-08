package com.example;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnector.connect()) {
            EmployeeDAO dao = new EmployeeDAO(conn);

            Employee emp = new Employee("Eve", 29, "Tester", 3200.00f);
            dao.addEmployee(emp);

            dao.getAllEmployees().forEach(System.out::println);

            dao.updateEmployeeSalary(1, 4500.00f);

            dao.deleteEmployee(2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}