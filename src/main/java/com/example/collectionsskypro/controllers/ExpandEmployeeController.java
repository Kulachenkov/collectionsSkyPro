package com.example.collectionsskypro.controllers;

import com.example.collectionsskypro.data.Employee;
import com.example.collectionsskypro.services.ExpandEmployeeService;
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
    private final ExpandEmployeeService expandEmployeeService;

    public ExpandEmployeeController(ExpandEmployeeService expandEmployeeService) {
        this.expandEmployeeService = expandEmployeeService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") int groupNumber) {
        return expandEmployeeService.maxSalary(groupNumber);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam("departmentId") int groupNumber) {
        return expandEmployeeService.minSalary(groupNumber);
    }
    @GetMapping(path = "/all", params = {"departmentId"})
    public Collection<Employee> employeeList(@RequestParam("departmentId") int groupNumber) {
        return expandEmployeeService.employeeList(groupNumber);
    }
    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> employeeFullList() {
        return expandEmployeeService.employeeList();
    }
}
