package com.springboot.employee.directory.service;

import com.springboot.employee.directory.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int theId);

    Employee save(Employee newEmployee);
    void deleteById(int Id);
}
