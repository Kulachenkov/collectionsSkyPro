package com.example.collectionsskypro.services;

import com.example.collectionsskypro.data.Employee;

import java.util.Set;

public interface EmployeeService {
    boolean addEmployee(String firstName, String lastName);
    boolean removeEmployee(String firstName, String lastName);
    boolean findEmployee(String firstName, String lastName);
    Set<String> getEmployeeList();

}
