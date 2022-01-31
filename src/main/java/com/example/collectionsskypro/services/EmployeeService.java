package com.example.collectionsskypro.services;

import com.example.collectionsskypro.data.Employee;

import java.util.HashMap;
import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName) ;
    Employee removeEmployee(String firstName, String lastName) ;
    Employee findEmployee(String firstName, String lastName);
    HashMap<Integer,Employee> getEmployeeList();

}
