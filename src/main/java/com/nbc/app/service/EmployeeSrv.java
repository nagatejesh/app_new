package com.nbc.app.service;

import com.nbc.app.model.Employee;

import java.util.List;

public interface EmployeeSrv {

    List<Employee> getAllEmployees();
    Long saveEmployee(Employee employee);
    Employee findEmployeeById(Long id);
    Employee findEmployeeByEmail(String email);
    void deleteEmployeeById(Long id);

}
