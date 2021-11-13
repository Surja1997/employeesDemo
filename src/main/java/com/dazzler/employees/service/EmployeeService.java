package com.dazzler.employees.service;

import com.dazzler.employees.exceptions.ResourceNotFoundException;
import com.dazzler.employees.model.Employee;
import org.springframework.http.ResponseEntity;


public interface EmployeeService {


    public Employee getEmployeeById(Long id) throws ResourceNotFoundException;

    public Employee saveEmployee(Employee employee);

    public  Employee deleteEmployeeById(Long employeeId) throws ResourceNotFoundException;


}
