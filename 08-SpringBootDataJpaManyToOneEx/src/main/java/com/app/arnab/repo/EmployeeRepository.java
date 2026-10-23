package com.app.arnab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.arnab.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
