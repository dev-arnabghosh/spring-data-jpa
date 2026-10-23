package com.app.arnab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.arnab.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
