package com.example.collectionsskypro.services.impl;

import com.example.collectionsskypro.data.Employee;
import com.example.collectionsskypro.exceptions.EmployeeExistsException;
import com.example.collectionsskypro.exceptions.EmployeeNotFoundException;
import com.example.collectionsskypro.exceptions.MyException;
import com.example.collectionsskypro.services.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceCollectImpl implements EmployeeService {

    private Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName)  {


        Employee employee = new Employee(StringUtils.capitalize(firstName), StringUtils.capitalize(lastName));
        String key = firstName + lastName;
        if (employees.containsKey(key) || !StringUtils.isAlpha(key)){
            throw new EmployeeExistsException("This employee already exists or name does not correct");
        }
            employees.put(key, employee);

        return employee;

    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employees.containsKey(key))  {
            throw new EmployeeExistsException("This employee can't be found.");
        }
        return employees.remove(key);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String key = firstName + lastName;
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("This employee cant be found.");
        }
            return employees.get(key);

    }

    private void employeeCheck(String firstName, String lastName) throws MyException {
        String key = firstName + lastName;
        if (employees.containsKey(key)) {
            throw new MyException("This employee already exists.");
        }
    }

    @Override
    public Collection<Employee> getEmployeeList() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
