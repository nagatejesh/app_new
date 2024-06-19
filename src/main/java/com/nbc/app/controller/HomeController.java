package com.nbc.app.controller;

import com.nbc.app.model.Employee;
import com.nbc.app.service.EmployeeSrvImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class HomeController {

    private final EmployeeSrvImpl employeeSrv;

    @Autowired
    public HomeController(EmployeeSrvImpl employeeSrv) {
        this.employeeSrv = employeeSrv;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeSrv.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}/delete")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        employeeSrv.deleteEmployeeById(id);
        return "Employee with id: "+id+"is deleted successfully!";
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeSrv.findEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeSrv.saveEmployee(employee);
    }
}
