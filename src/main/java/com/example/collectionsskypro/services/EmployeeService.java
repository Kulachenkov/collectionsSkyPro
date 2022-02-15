package com.example.collectionsskypro.services;

import com.example.collectionsskypro.data.Employee;
import com.example.collectionsskypro.exceptions.EmployeeExistsException;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName) throws EmployeeExistsException;
    Employee removeEmployee(String firstName, String lastName) throws EmployeeExistsException;
    Employee findEmployee(String firstName, String lastName);
    Collection<Employee> getEmployeeList();

}
