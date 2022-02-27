package com.example.collectionsskypro.services;

import com.example.collectionsskypro.exceptions.EmployeeNotFoundException;
import com.example.collectionsskypro.services.impl.EmployeeServiceCollectImpl;
import com.example.collectionsskypro.services.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.collectionsskypro.services.EmployeeServiceConstant.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeServiceCollectImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl out;

    @Test
    public void shouldFindEmployeeWithMaxSalaryById() {
        when(employeeService.getEmployeeList()).thenReturn(EMPLOYEES);
        assertEquals(MAX_SALARY_EMPLOYEE, out.maxSalary(ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenIdIsEmpty() {
        when(employeeService.getEmployeeList()).thenReturn(new ArrayList<>());
        assertThrows(EmployeeNotFoundException.class, () -> out.maxSalary(ID));
    }

    @Test
    public void shouldFindEmployeeWithMinSalaryById() {
        when(employeeService.getEmployeeList()).thenReturn(EMPLOYEES);
        assertEquals(MIN_SALARY_EMPLOYEE, out.minSalary(ID));
    }

    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenIdIsEmptyForMinSalary() {
        when(employeeService.getEmployeeList()).thenReturn(new ArrayList<>());
        assertThrows(EmployeeNotFoundException.class, () -> out.minSalary(ID));
    }


    @Test
    public void shouldReturnEmptyMapWhenEmployeesDontExist() {
        when(employeeService.getEmployeeList()).thenReturn(new ArrayList<>());
        assertEquals(new HashMap<>(),out.employeeList());
    }

    @Test
    public void shouldReturnAllEmployeesByGroupIdWhenEmployeeExist() {
        when(employeeService.getEmployeeList()).thenReturn(EMPLOYEES_GROUP_TWO);
        assertEquals(GROUP_MAP,out.employeeList());
    }

    @Test
    public void shouldReturnEmptyCollectionWhenNoEmployeesExistINGroup() {
        when(employeeService.getEmployeeList()).thenReturn(EMPLOYEES);
        assertEquals(new ArrayList<>(),out.employeeListByGroupNumber(ID_TWO));
    }

    @Test
    public void shouldReturnEmployeesByGroupNumberWhenEmployeeExistsThere() {
        when(employeeService.getEmployeeList()).thenReturn(EMPLOYEES_GROUP_TWO);
        assertEquals(List.of(MAX_SALARY_EMPLOYEE),out.employeeListByGroupNumber(ID));
        assertEquals(List.of(OTHER_GROUP_EMPLOYEE),out.employeeListByGroupNumber(ID_TWO));
    }
}
