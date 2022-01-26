package com.example.collectionsskypro.services.impl;

import com.example.collectionsskypro.data.Employee;
import com.example.collectionsskypro.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    Set<String> employeeList;

    public EmployeeServiceImpl(){
        employeeList = new HashSet<>();
    }


    @Override
    public boolean addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        return employeeList.add(employee.toString());
    }

    @Override
    public boolean removeEmployee(String firstName, String lastName) {
        return employeeList.remove(firstName +" "+ lastName);
    }

    @Override
    public boolean findEmployee(String firstName, String lastName) {
        return employeeList.contains(firstName +" "+ lastName);
    }

    @Override
    public Set<String> getEmployeeList() {
        return employeeList;
    }
}
