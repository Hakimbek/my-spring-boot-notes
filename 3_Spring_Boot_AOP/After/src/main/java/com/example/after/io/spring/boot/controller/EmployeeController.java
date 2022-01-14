package com.example.after.io.spring.boot.controller;

import com.example.after.io.spring.boot.model.Employee;
import com.example.after.io.spring.boot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/add/employee", method = RequestMethod.POST)
    public Employee addEmployee(@RequestParam("empId") String empId, @RequestParam("firstName") String firstName, @RequestParam("secondName") String secondName) {
        return employeeService.createEmployee(empId, firstName, secondName);
    }

    @RequestMapping(value = "/remove/employee", method = RequestMethod.GET)
    public String removeEmployee(@RequestParam("empId") String empId) {
        employeeService.deleteEmployee(empId);
        return "Employee removed";
    }

}
