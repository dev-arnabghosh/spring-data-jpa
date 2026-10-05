package com.app.arnab.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Employee;
import com.app.arnab.repository.EmployeeRepository;

//@Component
@org.springframework.core.annotation.Order(2)
public class TestDataFetch implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Iterable<Employee> list1 = repo.findAll();
		list1.forEach(System.out::println);

		// Case#1: 1 col - Asc Order
		Sort sort1 = Sort.by("empSal");
//		Sort sort1 = Sort.by(Direction.ASC, "empSal");
		Iterable<Employee> list2 = repo.findAll(sort1);
		list2.forEach(System.out::println);

		// Case#2: 1 col - Desc Order
		Sort sort3 = Sort.by(Direction.DESC, "empSal");
		Iterable<Employee> list3 = repo.findAll(sort3);
		list3.forEach(System.out::println);
		
		// Case#3: n cols - Same Order
//		Sort sort4 = Sort.by("empSal", "empDept"); // Both Ascending
		Sort sort4 = Sort.by(Direction.DESC,"empSal","empDept"); // Both Descending
		Iterable<Employee> list4 = repo.findAll(sort4);
		list4.forEach(System.out::println);
		
		
		// Case#4: n cols - Mixed Order
		Sort sort5 = Sort.by(
			Order.desc("empSal"),
			Order.asc("empDept")
		); // Mixed
		Iterable<Employee> list5 = repo.findAll(sort5);
		list5.forEach(System.out::println);
		
	}

}
