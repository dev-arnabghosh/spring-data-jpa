package com.app.arnab.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Department;
import com.app.arnab.entity.Employee;
import com.app.arnab.repo.DepartmentRepository;
import com.app.arnab.repo.EmployeeRepository;

@Component
public class TestDataInsertRunner implements CommandLineRunner {

	@Autowired
	private DepartmentRepository drepo;
	
	@Autowired
	private EmployeeRepository erepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Department d1 = new Department(101, "DEV", "Ram");
		drepo.save(d1);
		
		// if dept - already exists
		// Department d2 = drepo.findById(1053).get();
		
		Employee e1 = new Employee(10, "Shyam", 500.00, d1);
		Employee e2 = new Employee(11, "Shiva", 500.00, d1);
		Employee e3 = new Employee(12, "Vishnu", 500.00, d1);
		
		erepo.saveAll(List.of(e1, e2, e3));
	}

}
