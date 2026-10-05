package com.app.arnab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.app.arnab.entity.Employee;

public interface EmployeeRepository
		extends CrudRepository<Employee, Integer>, PagingAndSortingRepository<Employee, Integer> {

}
