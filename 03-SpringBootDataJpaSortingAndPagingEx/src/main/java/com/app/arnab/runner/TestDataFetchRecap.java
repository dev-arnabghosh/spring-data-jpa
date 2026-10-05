package com.app.arnab.runner;

import com.app.arnab.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.core.TypedPropertyPath;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Component;

import com.app.arnab.repository.EmployeeRepository;

//@Component
@org.springframework.core.annotation.Order(3)
public class TestDataFetchRecap implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// 1. select * from employee order by esal asc;
		// use static method by() present in sort class
		repo.findAll(Sort.by("empSal")).forEach(System.out::println);

		// 2. select * from employee order by esal desc;
		// Use direction property in by() method
		repo.findAll(Sort.by(Direction.DESC, "empSal")).forEach(System.out::println);

		// 3. select * from employee order by esal, dept asc;
		repo.findAll(Sort.by("empSal", "empDept")).forEach(System.out::println);

		// 3. select * from employee order by esal, dept desc;
		repo.findAll(Sort.by(Direction.DESC, "empSal", "empDept")).forEach(System.out::println);

		// 4. select * from employee order by esal desc, dept asc;
		repo.findAll(Sort.by(Order.desc("empSal"), Order.asc("empDept"))).forEach(System.out::println);

		repo.findAll(Sort.by("empSal")).forEach(System.out::println);
		repo.findAll(Sort.by(Order.desc("empSal"), Order.asc("empDept"))).forEach(System.out::println);

		TypedPropertyPath<Employee, Integer> empIdPath = employee -> employee.getEmpId();
		System.out.println(empIdPath.get());
		System.out.println(empIdPath.toDotPath());
		
		TypedPropertyPath<Employee, String> empNamePath = employee -> employee.getEmpName();
		System.out.println(empNamePath.get());
		System.out.println(empNamePath.toDotPath());
		
		
		TypedPropertyPath<Employee, Double> empSal = employee -> employee.getEmpSal();
		TypedPropertyPath<Employee, String> empDept = Employee::getEmpDept;
		
		repo.findAll(Sort.by(empSal)).forEach(System.out::println);
		repo.findAll(Sort.by(Order.desc(empSal), Order.asc(empDept))).forEach(System.out::println);
	
	}

}
