package com.app.arnab.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.BookRepository;
import com.app.arnab.entity.Book;

@Component
public class TestDataRunner implements CommandLineRunner {

	@Autowired
	private BookRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.saveAll(Arrays.asList(new Book(101, "SBMS", "Hari", 300.00, "Backend"),
				new Book(102, "CORE", "Ram", 200.00, "Backend"), new Book(103, "ADV", "Shaym", 400.00, "Backend"),
				new Book(104, "REACT", "Krishna", 500.00, "Frontend"),
				new Book(105, "HTML", "Hari", 600.00, "Frontend")));

		repo.findByAuthorIs("Hari").forEach(System.out::println);

		repo.findByBookType("Frontend").forEach(System.out::println);
		
//		repo.findByBookType("Frontend");

	}

}
