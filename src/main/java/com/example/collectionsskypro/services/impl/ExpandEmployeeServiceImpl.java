package com.example.collectionsskypro.services.impl;

import com.example.collectionsskypro.data.Employee;
import com.example.collectionsskypro.services.ExpandEmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpandEmployeeServiceImpl implements ExpandEmployeeService {


    private List<Employee> employees;

    public ExpandEmployeeServiceImpl() {

        this.employees = new ArrayList<>();
        employees.add(new Employee("Ivan", "Ivanov", 4, 34060.00));
        employees.add(new Employee("Petr", "Petrov", 2, 56560.00));
        employees.add(new Employee("Anna", "Ivanova", 4, 74500.00));
        employees.add(new Employee("Vova", "Fedorov", 2, 74453.00));
        employees.add(new Employee("Sergey", "Sergeev", 2, 12000.00));
        employees.add(new Employee("Leonid", "Sidorov", 4, 37054.00));

    }
    @Override
    public Employee maxSalary(int groupNumber) {
        return employees.stream()
                .filter(employee -> employee.getGroupNumber() == groupNumber)
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .get();
    }

    @Override
    public Employee minSalary(int groupNumber) {
        return employees.stream()
                .filter(employee -> employee.getGroupNumber() == groupNumber)
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .get();
    }

    @Override
    public List<Employee> employeeList(int groupNumber) {
        return employees.stream()
                .filter(employee -> employee.getGroupNumber() == groupNumber)
                .collect(Collectors.toList());
    }

    @Override
    public List<Employee> employeeList() {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getGroupNumber))
                .collect(Collectors.toList());
    }
}
