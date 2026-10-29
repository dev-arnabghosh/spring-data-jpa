package com.app.arnab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.arnab.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
