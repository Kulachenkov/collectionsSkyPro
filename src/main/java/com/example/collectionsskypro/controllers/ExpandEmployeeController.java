package com.example.collectionsskypro.controllers;

import com.example.collectionsskypro.data.Employee;
import com.example.collectionsskypro.services.ExpandEmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class ExpandEmployeeController {
    private ExpandEmployeeService expandEmployeeService;

    public ExpandEmployeeController(ExpandEmployeeService expandEmployeeService) {
        this.expandEmployeeService = expandEmployeeService;
    }

    @RequestMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") int groupNumber) {
        return expandEmployeeService.maxSalary(groupNumber);
    }

    @RequestMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam("departmentId") int groupNumber) {
        return expandEmployeeService.minSalary(groupNumber);
    }
    @RequestMapping(path = "/all")
    public List<Employee> employeeList(@RequestParam("departmentId") int groupNumber) {
        return expandEmployeeService.employeeList(groupNumber);
    }
    @RequestMapping(path = "/full")
    public List<Employee> employeeFullList() {
        return expandEmployeeService.employeeList();
    }
}
