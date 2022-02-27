package com.example.collectionsskypro.controllers;

import com.example.collectionsskypro.data.Employee;
import com.example.collectionsskypro.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class ExpandEmployeeController {
    private final DepartmentService departmentService;

    public ExpandEmployeeController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") int groupNumber) {
        return departmentService.maxSalary(groupNumber);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam("departmentId") int groupNumber) {
        return departmentService.minSalary(groupNumber);
    }
    @GetMapping(path = "/all", params = {"departmentId"})
    public Collection<Employee> employeeListByGroupNumber(@RequestParam("departmentId") int groupNumber) {
        return departmentService.employeeListByGroupNumber(groupNumber);
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> employeeFullList() {
        return departmentService.employeeList();
    }
}
