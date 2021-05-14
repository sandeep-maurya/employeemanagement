package com.springboot.employeemanagement.controller;

import com.springboot.employeemanagement.model.Employee;
import com.springboot.employeemanagement.repository.EmployeeRepository;
import com.springboot.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployee(){
        return employeeService.findAllEmployee();
    }

    @GetMapping("/find/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.findEmployeeById(id);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @PostMapping("/addMany")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return employeeService.addEmployees(employees);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id){
        return new ResponseEntity<String>(employeeService.deleteEmployee(id), HttpStatus.OK);
    }
}
