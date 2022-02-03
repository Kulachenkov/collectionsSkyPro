package com.example.collectionsskypro.services;

import com.example.collectionsskypro.data.Employee;

import java.util.List;

public interface ExpandEmployeeService {

    Employee maxSalary(int groupNumber);

    Employee minSalary(int groupNumber);

    List<Employee> employeeList(int groupNumber);

    List<Employee> employeeList();


}
