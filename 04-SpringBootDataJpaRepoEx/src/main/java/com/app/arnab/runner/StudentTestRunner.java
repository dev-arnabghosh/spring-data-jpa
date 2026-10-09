package com.app.arnab.runner;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Student;
import com.app.arnab.repo.StudentRepository;

@Component
public class StudentTestRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Student s1 = new Student();
		s1.setStdName("Arnab");
		s1.setStdFee(200.0);
		
		//s1.setStdDoj(new Date()); // for temporal code
		s1.setStdDoj(LocalDate.now()); // Today's date
		//s1.setStdDoj(LocalDate.of(2026, 10, 6)); // yyyy mm dd - Specific date
		
		s1.setLoginTime(LocalDateTime.now());
		s1.setLoginTime(
				LocalDateTime.of(2026, 10, 6, // year, month, day
						20, 30, 45, // hour, minute, second
						123456789 // nanosecond
		));

		repo.save(s1);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
		String s = sdf.format(new Date());
		System.out.println(s);
		
		List<Student> students = repo.findAll();
		System.out.println(students.getClass().getName());
		students.forEach(System.out::println);
		
		Student sob = new Student();
		sob.setStdFee(400.00);
		sob.setStdName("Ajay");
		Example<Student> prob = Example.of(sob);
		repo.findAll(prob).forEach(System.out::println);
	}

}
