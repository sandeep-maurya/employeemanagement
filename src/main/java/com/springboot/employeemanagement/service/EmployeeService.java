package com.springboot.employeemanagement.service;

import com.springboot.employeemanagement.model.Employee;
import com.springboot.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Employee employee){
        Employee getEmployee = employeeRepository.findById(employee.getId()).orElse(null);
        getEmployee.setName(employee.getName());
        getEmployee.setEmail(employee.getEmail());
        getEmployee.setImageUrl(employee.getImageUrl());
        getEmployee.setJobTitle(employee.getJobTitle());
        getEmployee.setPhone(employee.getPhone());

        return employeeRepository.save(getEmployee);
    }

    public String deleteEmployee(Long id){
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully : " + id;
    }

    public List<Employee> addEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }
}
