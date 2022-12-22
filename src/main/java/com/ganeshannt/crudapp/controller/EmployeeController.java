package com.ganeshannt.crudapp.controller;

import com.ganeshannt.crudapp.entity.Employee;
import com.ganeshannt.crudapp.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ganeshan Nagarajan
 * @since 21/12/22
 */


@RestController
@RequestMapping("/api/employee/")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/v1/registration")
    public Employee register(
            @RequestParam(name = "firstName", required = true) String firstName,
            @RequestParam(name = "lastName", required = true) String lastName,
            @RequestParam(name = "mobileNumber", required = true) String mobileNumber,
            @RequestParam(name = "address", required = true) String address,
            @RequestParam(name = "department", required = true) String department
    ) {
        return employeeService.register(firstName, lastName, mobileNumber, address, department);
    }

    @GetMapping("/v1/get")
    public List<Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @DeleteMapping("/v1/delete")
    public String deleteEmployee(
            @RequestParam(value = "user_id", required = true) long userId
    ) {
        return employeeService.deleteEmployee(userId);
    }

    @PatchMapping("/v1/update/{user_id}")
    public Employee updateEmployee(
            @PathVariable("user_id") long userId,
            @RequestBody Employee employee
    ) {
        return employeeService.updateEmployee(userId,employee);
    }
}
