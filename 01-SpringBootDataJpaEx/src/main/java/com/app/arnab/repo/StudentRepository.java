package com.app.arnab.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.arnab.entity.Student;

public interface StudentRepository 
	extends CrudRepository<Student, Integer> {

}
