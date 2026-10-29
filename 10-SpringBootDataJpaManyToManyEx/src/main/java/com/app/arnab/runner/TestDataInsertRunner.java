package com.app.arnab.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Course;
import com.app.arnab.entity.Student;
import com.app.arnab.repo.CourseRepo;
import com.app.arnab.repo.StudentRepo;

@Component
public class TestDataInsertRunner implements CommandLineRunner {

	@Autowired
	private CourseRepo crepo;

	@Autowired
	private StudentRepo srepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Course c1 = new Course(50, "Springboot", 500.0);
		Course c2 = new Course(51, "Angular", 600.0);

		crepo.saveAll(List.of(c1, c2));

		Student s1 = new Student(10, "AJAY", "aj@gmail.com", Arrays.asList(c1, c2));
		Student s2 = new Student(11, "SAM", "sm@gmail.com", Arrays.asList(c1, c2));

		srepo.saveAll(List.of(s1, s2));

	}

}
