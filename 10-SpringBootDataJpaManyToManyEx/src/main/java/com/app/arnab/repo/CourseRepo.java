package com.app.arnab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.arnab.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer> {

}
