package com.example.collectionsskypro.controllers;

import com.example.collectionsskypro.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String greetEmployee(){
        return "Welcome to the project!";
    }
    @GetMapping("/add")
    public boolean addEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName){

        return employeeService.addEmployee(firstName, lastName);
    }
    @GetMapping("/remove")
    public boolean removeEmployee(@RequestParam("firstName") String firstName,
                                  @RequestParam("lastName") String lastName){
        return employeeService.removeEmployee(firstName, lastName);
    }
    @GetMapping("/find")
    public boolean findEmployee(@RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName){
        return employeeService.findEmployee(firstName, lastName);
    }
    @GetMapping(path = "/get/employee-list")
    public Set<String> getEmployeeList() {
        return employeeService.getEmployeeList();
    }



}
