package com.example.collectionsskypro.services;

import com.example.collectionsskypro.data.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface ExpandEmployeeService {

    Employee maxSalary(int groupNumber);

    Employee minSalary(int groupNumber);

    Collection<Employee> employeeListByGroupNumber(int groupNumber);

    Map<Integer, List<Employee>> employeeList();


}
