package com.app.arnab.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Book;
import com.app.arnab.repo.BookRepository;

@Component
public class TestDataRunner implements CommandLineRunner {

	@Autowired
	private BookRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.saveAll(Arrays.asList(//
				new Book(101, "SBMS", "Hari", 300.00, "Backend"), //
				new Book(102, "CORE", "Ram", 200.00, "Backend"), //
				new Book(103, "ADV", "Shyam", 400.00, "Backend"), //
				new Book(104, "REACT", "Krishna", 500.00, "Frontend"), //
				new Book(105, "HTML", null, 600.00, "Frontend"), //
				new Book(106, "CSS", "Krishna", 300.00, "Frontend"), //
				new Book(107, "ANGULAR", "Shiva", 400.00, "Frontend"), //
				new Book(108, "SQL", "Shiva", 700.00, "Frontend"), //
				new Book(109, "NEXT", null, 600.00, "Frontend")//
		));

		// repo.getBooksByAuthor("Shiva").forEach(System.out::println);
		
		 repo.getBooksByAuthorOrCost("k%", 500.00).forEach(System.out::println);
		
		//repo.getBookIds(Arrays.asList(103, 105, 108)).forEach(System.out::println);

	}

}
