package com.example.collectionsskypro.services;

import com.example.collectionsskypro.data.Employee;
import java.util.*;
import static java.util.stream.Collectors.groupingBy;

public class EmployeeServiceConstant {

    public static final String DEFAULT_PARAM = "Employee";
    public static final String ILLEGAL_CHARACTERS_PARAM = "Employee33";
    public static final String CORRECT_PARAM = "Employee";
    public static final String CORRECT_PARAM_TWO = "EmployeeNew";

    public static final String FIRST_NAME = "Ivan";
    public static final String SECOND_NAME = "Ivanov";
    public static final String FIRST_NAME_TWO = "Petr";
    public static final String SECOND_NAME_TWO = "Sidorov";
    public static final int MAX_SALARY = 2000;
    public static final int MIN_SALARY = 1000;
    public static final int ID = 2;
    public static final int ID_TWO = 3;

    public static final Employee MAX_SALARY_EMPLOYEE = new Employee(FIRST_NAME,SECOND_NAME,ID,MAX_SALARY);
    public static final Employee MIN_SALARY_EMPLOYEE = new Employee(FIRST_NAME_TWO,SECOND_NAME_TWO,ID,MIN_SALARY);
    public static final Employee OTHER_GROUP_EMPLOYEE = new Employee(CORRECT_PARAM_TWO, CORRECT_PARAM_TWO,ID_TWO,MIN_SALARY);
    public static final Set<Employee> EMPLOYEES = Set.of(MAX_SALARY_EMPLOYEE, MIN_SALARY_EMPLOYEE);
    public static final Set<Employee> EMPLOYEES_GROUP_TWO = Set.of(MAX_SALARY_EMPLOYEE, OTHER_GROUP_EMPLOYEE);
    public static final Map<Integer, List<Employee>> GROUP_MAP = EMPLOYEES_GROUP_TWO.stream().collect(groupingBy(Employee::getGroupNumber));

}
