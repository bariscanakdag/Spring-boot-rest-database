package com.baris.springbootrest.rest;

import com.baris.springbootrest.entity.Employee;
import com.baris.springbootrest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> getEmployee(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);

        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public Employee deleteEmployee(@PathVariable int employeeId) {
        Optional<Employee> tempEmployee= employeeService.findById(employeeId);
        employeeService.deleteById(employeeId);

        return tempEmployee.get();

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }
}
