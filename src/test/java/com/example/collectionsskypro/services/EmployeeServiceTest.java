package com.example.collectionsskypro.services;

import com.example.collectionsskypro.data.Employee;
import com.example.collectionsskypro.exceptions.EmployeeExistsException;
import com.example.collectionsskypro.exceptions.EmployeeNotFoundException;
import com.example.collectionsskypro.services.impl.EmployeeServiceCollectImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static com.example.collectionsskypro.services.EmployeeServiceConstant.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private EmployeeServiceCollectImpl employeeServiceCollect = new EmployeeServiceCollectImpl();

    @BeforeEach
    private void setUp() {
        employeeServiceCollect = new EmployeeServiceCollectImpl();
    }

    public static Stream<Arguments> parametersForTest() {
        return Stream.of(
                Arguments.of(DEFAULT_PARAM, DEFAULT_PARAM, CORRECT_PARAM, CORRECT_PARAM),
                Arguments.of(CORRECT_PARAM, CORRECT_PARAM, CORRECT_PARAM, CORRECT_PARAM),
                Arguments.of(DEFAULT_PARAM, CORRECT_PARAM, CORRECT_PARAM, CORRECT_PARAM),
                Arguments.of(CORRECT_PARAM, DEFAULT_PARAM, CORRECT_PARAM, CORRECT_PARAM),
                Arguments.of(null,null,null,null)
        );
    }

    public static Stream<Arguments> parametersForWrongNamesTest() {
        return Stream.of(
                Arguments.of(ILLEGAL_CHARACTERS_PARAM, ILLEGAL_CHARACTERS_PARAM),
                Arguments.of(CORRECT_PARAM, ILLEGAL_CHARACTERS_PARAM),
                Arguments.of(ILLEGAL_CHARACTERS_PARAM, CORRECT_PARAM)
        );
    }


    @ParameterizedTest
    @MethodSource("parametersForWrongNamesTest")
    public void shouldReturnThrowsWhenAddEmployee(String firstName, String lastName) {
        employeeServiceCollect.addEmployee(CORRECT_PARAM, CORRECT_PARAM);
        assertThrows(EmployeeExistsException.class, () -> employeeServiceCollect.addEmployee(firstName, lastName));
        assertThrows(EmployeeExistsException.class, () ->  employeeServiceCollect.addEmployee(CORRECT_PARAM, CORRECT_PARAM));
    }

    @ParameterizedTest
    @MethodSource("parametersForTest")
    public void shouldAddEmployee(String firstName, String lastName, String correctFirstName, String correctLastName) {
        Employee employee = new Employee(correctFirstName, correctLastName);
        assertEquals(0,employeeServiceCollect.getEmployeeList().size());
        assertEquals(employeeServiceCollect.addEmployee(firstName,lastName), employee);
        assertTrue(employeeServiceCollect.getEmployeeList().contains(employee));
    }

    @ParameterizedTest
    @MethodSource("parametersForTest")
    public void shouldRemoveEmployee(String firstName, String lastName, String correctFirstName, String correctLastName) {
        employeeServiceCollect.addEmployee(correctFirstName, correctLastName);
        assertEquals(employeeServiceCollect.removeEmployee(firstName,lastName), new Employee(correctFirstName,correctLastName));
    }

    @Test
    public void shouldReturnThrowsWhenFindEmployee() {
        assertEquals(0,employeeServiceCollect.getEmployeeList().size());
        assertThrows(EmployeeNotFoundException.class, () -> employeeServiceCollect.findEmployee(CORRECT_PARAM,CORRECT_PARAM));

    }

    @ParameterizedTest
    @MethodSource("parametersForTest")
    public void shouldFindEmployee(String firstName, String lastName, String correctFirstName, String correctLastName) {
        employeeServiceCollect.addEmployee(correctFirstName, correctLastName);
        assertEquals(employeeServiceCollect.findEmployee(firstName,lastName), new Employee(correctFirstName,correctLastName));
    }

    @Test
    public void shouldTrueWhenRemoveEmployee() {
        Employee employee = employeeServiceCollect.addEmployee(CORRECT_PARAM, CORRECT_PARAM);
        assertEquals(1,employeeServiceCollect.getEmployeeList().size());
        Employee outEmployee = employeeServiceCollect.removeEmployee(CORRECT_PARAM, CORRECT_PARAM);
        assertEquals(employee, outEmployee);
        assertTrue(employeeServiceCollect.getEmployeeList().isEmpty());
        assertFalse(employeeServiceCollect.getEmployeeList().contains(employee));
    }

    @Test
    public void shouldReturnThrowsWhenRemoveEmployee() {
        assertTrue(employeeServiceCollect.getEmployeeList().isEmpty());
        assertThrows(EmployeeNotFoundException.class, () -> employeeServiceCollect.removeEmployee(CORRECT_PARAM, CORRECT_PARAM));
    }


}
