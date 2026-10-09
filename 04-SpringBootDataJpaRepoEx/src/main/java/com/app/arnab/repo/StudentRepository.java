package com.app.arnab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.arnab.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
}
