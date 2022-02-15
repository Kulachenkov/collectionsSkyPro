package com.example.collectionsskypro.data;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int groupNumber;
    private double salary;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupNumber = 0;
        this.salary = 0;
    }

    public Employee(String firstName, String lastName, int groupNumber, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupNumber = groupNumber;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Math.abs(Objects.hash(firstName, lastName));
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
