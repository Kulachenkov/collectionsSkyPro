package com.example.collectionsskypro.services.impl;

import com.example.collectionsskypro.data.Employee;
import com.example.collectionsskypro.exceptions.EmployeeExistsException;
import com.example.collectionsskypro.exceptions.EmployeeNotFoundException;
import com.example.collectionsskypro.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeServiceCollectImpl implements EmployeeService {

    private HashMap<Integer, Employee> employees;

    public EmployeeServiceCollectImpl() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName)  {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsValue(employee)){
            throw new EmployeeExistsException("This employee already exists");
        }else {
            employees.put(employee.hashCode(), employee);
            return employee;
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsValue(employee))  {
            throw new EmployeeExistsException("This employee can't be found.");
        }
        employees.remove(employee.hashCode());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsValue(employee)) {
            throw new EmployeeNotFoundException("This employee cant be found.");
        } else {
            return employee;
        }
    }

    @Override
    public HashMap<Integer,Employee> getEmployeeList() {
        return employees;
    }
}
