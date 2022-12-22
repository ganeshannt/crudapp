package com.ganeshannt.crudapp.service;

import com.ganeshannt.crudapp.entity.Employee;
import com.ganeshannt.crudapp.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee register(String firstName, String lastName, String mobileNumber, String address, String department) {
        Employee emp = new Employee(firstName, lastName, mobileNumber, address, department);
        return employeeRepository.save(emp);
    }

    public List<Employee> getEmployeeList() {
        return employeeRepository.findAll();
    }

    public String deleteEmployee(long userId) {
        employeeRepository.deleteById(userId);
        String response = "User deleted Successfully";
        return response;
    }

    public Employee updateEmployee(long userId, Employee employee) {
        Employee emp = employeeRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found on DB:: " + userId));
        emp.setFirstName(employee.getFirstName());
        return employeeRepository.save(emp);
    }
}

