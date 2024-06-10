package com.springboot.employee.directory.controller;

import com.springboot.employee.directory.entity.Employee;
import com.springboot.employee.directory.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        List<Employee> theEmployees=employeeService.findAll();
        theModel.addAttribute("employees",theEmployees);
        return "employees/list-employees";
    }

    @GetMapping("/addEmployee")
    public String addEmployeeDetails(Model theModel){
        Employee employee = new Employee();
        theModel.addAttribute("employee",employee);
        return "employees/employee-form";
    }
    @GetMapping("/updateEmployee")
    public String updateEmployeeDetails(@RequestParam("employeeId") int theId, Model theModel){
        Employee employee =employeeService.findById(theId);
        theModel.addAttribute("employee",employee);
        return "employees/employee-form";
    }
    @GetMapping("/deleteEmployee")
    public String deleteEmployeeDetails(@RequestParam("employeeId") int theId){
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employeeDetails){
        employeeService.save(employeeDetails);
        return "redirect:/employees/list";
    }
}
