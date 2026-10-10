package com.app.arnab;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.arnab.entity.Book;
import java.util.List;


public interface BookRepository extends JpaRepository<Book, Integer> {
	/*
	 * Output findBy<Variable><condition>(Datatype param)
	 * Variable Name can be same case or camelCase (recommended in Java)
	 * */
	// SQL: SELECT * FROM BOOK WHERE AUTHOR=?
	List<Book> findByauthor(String author);
	List<Book> findByAuthor(String author);
	List<Book> findByAuthorIs(String author);
	List<Book> findByAuthorEquals(String author);
	
	// SELECT * FROM BOOK WHERE BOOTYPE=?
//	List<Book> findByBookType(String bookType);	
	
	List<Book> findByBookType(String bookType);	
//	Book findByBookType(String bookType);	// NonUniqueResultException
	
	
}
