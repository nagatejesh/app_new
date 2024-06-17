package com.nbc.app.dao;

import com.nbc.app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    Employee findAllByEmail(String email);
}
