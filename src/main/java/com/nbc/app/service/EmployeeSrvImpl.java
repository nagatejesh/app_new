package com.nbc.app.service;

import com.nbc.app.dao.EmployeeRepo;
import com.nbc.app.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeSrvImpl implements EmployeeSrv{
    public final EmployeeRepo employeeSrvc;

    @Autowired
    public EmployeeSrvImpl(EmployeeRepo employeeSrvc) {
        this.employeeSrvc = employeeSrvc;
    }


    @Override
    public List<Employee> getAllEmployees() {
        return employeeSrvc.findAll();
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeSrvc.save(employee);
    }

    @Override
    public Employee findEmployeeById(Long id) {
        return employeeSrvc.findById(id).orElseGet(Employee::new);
    }

    @Override
    public Employee findEmployeeByEmail(String email) {
        return employeeSrvc.findAllByEmail(email);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeSrvc.deleteById(id);
    }
}
