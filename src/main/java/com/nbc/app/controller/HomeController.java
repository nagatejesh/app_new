package com.nbc.app.controller;

import com.nbc.app.exception.EmployeeNotFoundException;
import com.nbc.app.model.Employee;
import com.nbc.app.service.EmployeeSrvImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class HomeController {

    @Autowired
    private EmployeeSrvImpl employeeSrv;

    @GetMapping("")
    public String welcome(){
        return "Welcome to Employee Management App created by yours truly using SpringBoot REST";
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeSrv.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}")
    public List<Employee> deleteEmployeeById(@PathVariable("id") Long id){
        employeeSrv.deleteEmployeeById(id);
        return employeeSrv.getAllEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id) throws EmployeeNotFoundException{

        Employee employeeById = employeeSrv.findEmployeeById(id);
        if(employeeById.getId()!=id)
            throw new EmployeeNotFoundException(id);
        return employeeById;
    }

    @PostMapping("/employee")
    public List<Employee> saveEmployee(@RequestBody Employee employee){
        employeeSrv.saveEmployee(employee);
        return employeeSrv.getAllEmployees();
    }
}
