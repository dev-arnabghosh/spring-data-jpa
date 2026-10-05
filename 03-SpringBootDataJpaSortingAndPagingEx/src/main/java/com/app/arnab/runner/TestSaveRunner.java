package com.app.arnab.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Employee;
import com.app.arnab.repository.EmployeeRepository;

@Component
@Order(1)
public class TestSaveRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Employee[] employees = new Employee[] {
				new Employee(10, "ABC", 200.0, "DE"),
			    new Employee(11, "XYZ", 200.0, "QA"),
			    new Employee(12, "MNO", 200.0, "BA"),
			    new Employee(13, "PQR", 300.0, "DEV"),
			    new Employee(14, "GGH", 300.0, "BA"),
			    new Employee(15, "YHU", 300.0, "QA"),
			    new Employee(16, "UYH", 400.0, "DEV"),
			    new Employee(17, "RGS", 400.0, "BA"),
			    new Employee(18, "IJD", 400.0, "QA")
		};
		
		// jdk-1.5
		// repo.saveAll(Arrays.asList(employees));
		
		// jdk-9
		repo.saveAll(List.of(employees));
		
	}

}
