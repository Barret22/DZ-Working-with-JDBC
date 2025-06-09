package com.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void addEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employees (name, age, position, salary) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, emp.getName());
            stmt.setInt(2, emp.getAge());
            stmt.setString(3, emp.getPosition());
            stmt.setFloat(4, emp.getSalary());
            stmt.executeUpdate();
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("position"),
                        rs.getFloat("salary")
                ));
            }
        }
        return list;
    }

    public void updateEmployeeSalary(int id, float newSalary) throws SQLException {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setFloat(1, newSalary);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}