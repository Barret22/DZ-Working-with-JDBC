package com.example;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String position;
    private float salary;

    public Employee(int id, String name, int age, String position, float salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    public Employee(String name, int age, String position, float salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    // Getters и Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}