package com.example.collectionsskypro.services.impl;

import com.example.collectionsskypro.data.Employee;
import com.example.collectionsskypro.exceptions.EmployeeNotFoundException;
import com.example.collectionsskypro.services.ExpandEmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExpandEmployeeServiceImpl implements ExpandEmployeeService {


    private final EmployeeServiceCollectImpl employees;

    public ExpandEmployeeServiceImpl(EmployeeServiceCollectImpl employees) {
        this.employees = employees;
    }

    @Override
    public Employee maxSalary(int groupNumber) {
        return employees.getEmployeeList().stream()
                .filter(employee -> employee.getGroupNumber() == groupNumber)
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("This employee has been already added."));
    }

    @Override
    public Employee minSalary(int groupNumber) {
        return employees.getEmployeeList().stream()
                .filter(employee -> employee.getGroupNumber() == groupNumber)
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException("This employee has been already added."));
    }

    @Override
    public Collection<Employee> employeeList(int groupNumber) {
        return employees.getEmployeeList().stream()
                .filter(employee -> employee.getGroupNumber() == groupNumber)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> employeeList() {
        return employees.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getGroupNumber));
    }
}
