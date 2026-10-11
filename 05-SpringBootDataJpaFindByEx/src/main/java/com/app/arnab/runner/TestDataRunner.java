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

		repo.findByAuthorIs("Hari").forEach(System.out::println);

		repo.findByBookType("Frontend").forEach(System.out::println);

		repo.findByBookType("Frontend");

		repo.findByBookCostLessThanEqual(500.0).forEach(System.out::println);

		repo.findByAuthorIsNull().forEach(System.out::println);

		repo.findByAuthorIsNotNull().forEach(System.out::println);

		repo.findByBookNameLike("A%").forEach(System.out::println);

		repo.findByBookNameStartingWith("A").forEach(System.out::println);

		repo.findByBookNameEndingWith("S").forEach(System.out::println);

		repo.findByBookNameLike("___").forEach(System.out::println);

		repo.findByBookNameContaining("R").forEach(System.out::println);

		repo.findByBookNameNotLike("___").forEach(System.out::println);

		repo.findByAuthorNotLike("Shiva").forEach(System.out::println);

		repo.findByBookTypeEqualsAndBookCostLessThan("Frontend", 600.0).forEach(System.out::println);

		Optional<Book> book = repo.findById(105);
		if (book.isPresent()) {
			System.out.println(book.get());
		} else {
			System.out.println("Book Id not found");
		}

		repo.findAllByOrderByBookNameAsc().forEach(System.out::println);

		repo.findAllByOrderByBookCostDesc().forEach(System.out::println);

		repo.findAllByOrderByBookTypeAscBookCostDesc().forEach(System.out::println);

		repo.findByBookTypeOrderByBookCostDesc("Frontend").forEach(System.out::println);

		repo.findByAuthorIgnoreCase("hari").forEach(System.out::println);

		repo.findByBookCostBetween(200.0, 300.0).forEach(System.out::println);

	}

}
