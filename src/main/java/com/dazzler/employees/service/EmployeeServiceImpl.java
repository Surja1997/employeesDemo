package com.dazzler.employees.service;

import com.dazzler.employees.exceptions.EmptyInputException;
import com.dazzler.employees.exceptions.ResourceNotFoundException;
import com.dazzler.employees.model.Employee;
import com.dazzler.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee getEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id ::" + employeeId));
        return employee;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getFirstName().isEmpty() || employee.getLastName().isEmpty() || employee.getFirstName().length() == 0 || employee.getLastName().length() == 0)
            throw new EmptyInputException("601", "Input Fields are empty");
        return employeeRepository.save(employee);
    }

    @Override
    public Employee deleteEmployeeById(Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with this id ::" + employeeId));
        employeeRepository.delete(employee);
        return employee;
    }
}
