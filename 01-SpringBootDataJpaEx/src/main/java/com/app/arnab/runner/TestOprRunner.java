package com.app.arnab.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Student;
import com.app.arnab.repo.StudentRepository;

@Component
public class TestOprRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(repo.getClass().getName());
		
		Student sob = new Student();
		sob.setStdId(99);
		sob.setStdName("John");
		sob.setStdFee(200000.0);
		
		repo.save(sob); // INSERT or UPDATE
	}

}
