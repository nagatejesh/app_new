package com.nbc.app.controller;

import com.nbc.app.model.Employee;
import com.nbc.app.service.EmployeeSrvImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/")
public class HomeController {

    @Autowired
    private EmployeeSrvImpl employeeSrv;

    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> getAllEmployees(){
        return employeeSrv.getAllEmployees();
    }

    @DeleteMapping("/employee/{id}/delete")
    public String deleteEmployeeById(@PathVariable("id") Long id){
        employeeSrv.deleteEmployeeById(id);
        return "redirect:/employees";
    }

    @GetMapping("/employee/{id}")
    @ResponseBody
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeSrv.findEmployeeById(id);
    }

    @PostMapping("/employee")
    public String saveEmployee(@RequestBody Employee employee){
        employeeSrv.saveEmployee(employee);
        return "redirect:/employees";
    }
}
