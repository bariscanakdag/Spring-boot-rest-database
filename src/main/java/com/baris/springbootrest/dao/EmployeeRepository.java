package com.baris.springbootrest.dao;

import com.baris.springbootrest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
