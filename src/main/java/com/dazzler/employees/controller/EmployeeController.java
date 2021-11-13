package com.dazzler.employees.controller;

import com.dazzler.employees.exceptions.ResourceNotFoundException;
import com.dazzler.employees.model.Employee;
import com.dazzler.employees.repository.EmployeeRepository;
import com.dazzler.employees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    //get employees
    @GetMapping("employees")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    //get employees by id
    @GetMapping("employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    //save employee
    @PostMapping("saveEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee employee1 = employeeService.saveEmployee(employee);

        return new ResponseEntity<>(employee1,HttpStatus.CREATED);
    }

    //update employee
    @PutMapping("updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee emp =  employeeRepository.save(employee);
        return ResponseEntity.ok().body(emp);
    }

    //delete employee
    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        employeeService.deleteEmployeeById(employeeId);
        return  new ResponseEntity<>(HttpStatus.ACCEPTED);
    }


}
