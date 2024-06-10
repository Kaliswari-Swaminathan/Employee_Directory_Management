package com.springboot.employee.directory.service;

import com.springboot.employee.directory.dao.EmployeeRepository;
import com.springboot.employee.directory.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepo) {
        this.employeeDAO = theEmployeeRepo;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAllByOrderByFirstNameAsc();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeDAO.findById(theId);
        Employee theEmployee=null;
        if(result.isPresent()){
            theEmployee=result.get();
        }
        else{
            throw new RuntimeException("Did not find the Employee id - "+theId);
        }
        return theEmployee;
    }

    @Override
    public Employee save(Employee newEmployee) {
        return employeeDAO.save(newEmployee);
    }

    @Override
    public void deleteById(int Id) {
    employeeDAO.deleteById(Id);
    }
}
