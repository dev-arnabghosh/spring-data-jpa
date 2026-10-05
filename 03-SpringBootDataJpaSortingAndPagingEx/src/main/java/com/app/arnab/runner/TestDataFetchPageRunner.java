package com.app.arnab.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Employee;
import com.app.arnab.repository.EmployeeRepository;

@Component
@Order(4)
public class TestDataFetchPageRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// input
		Pageable p = PageRequest.of(1, 4);
		//Pageable p = PageRequest.of(44, 4); // no error - 0 rows

		// output
		Page<Employee> page = repo.findAll(p);

		// result
		page.getContent().forEach(System.out::println);

		// metadata
		System.out.println(page.isFirst());
		System.out.println(page.isLast());
		System.out.println(page.isEmpty());
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		System.out.println(page.getSize());
		System.out.println(page.hasContent());

	}

}
