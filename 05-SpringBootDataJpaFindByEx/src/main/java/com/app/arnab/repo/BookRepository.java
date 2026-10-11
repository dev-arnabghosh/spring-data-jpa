package com.app.arnab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.arnab.entity.Book;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {

	/*
	 * Output findBy<Variable><condition>(Datatype param) Variable Name can be same
	 * case or camelCase (recommended in Java)
	 */

	// findBy --> SELECT + where =, !=, >, <, null, not null, and, or...etc

	// SQL: SELECT * FROM BOOKTAB WHERE AUTHOR=?
	List<Book> findByauthor(String author);

	List<Book> findByAuthor(String author);

	List<Book> findByAuthorIs(String author);

	List<Book> findByAuthorEquals(String author);

	// SELECT * FROM BOOK WHERE BOOTYPE=?
	List<Book> findByBookType(String bookType);

	// Book findByBookType(String bookType); // NonUniqueResultException

	// select * from booktab where bcost!=?
	List<Book> findByBookIdNot(Integer bookId);

	// select * from booktab where bcost=?
	List<Book> findByBookCostEquals(Double bookCost);

	// select * from booktab where bcost>?
	List<Book> findByBookCostGreaterThan(Double bookCost);

	// select * from booktab where bcost<=?
	List<Book> findByBookCostLessThanEqual(Double bookCost);

	// select * from booktab where bcost is NULL
	List<Book> findByAuthorIsNull();

	// select * from booktab where bcost is not NULL
	List<Book> findByAuthorIsNotNull();

	// SELECT * FROM booktab WHERE bname = ?;
	List<Book> findByBookName(String bookName);

	// select * from booktab where bauthor LIKE 'Shiva'
	List<Book> findByAuthorLike(String expression);

	// select * from booktab where bauthor NOT LIKE 'Shiva'
	List<Book> findByAuthorNotLike(String pattern);

	// select * from booktab where bname LIKE 'A%'
	List<Book> findByBookNameStartingWith(String prefix);

	// select * from booktab where bname LIKE '%S'
	List<Book> findByBookNameEndingWith(String suffix);

	// select * from booktab where bname LIKE '___'
	List<Book> findByBookNameLike(String pattern);

	// select * from booktab where bname LIKE '%R%'
	List<Book> findByBookNameContaining(String text);

	// select * from booktab where bname NOT LIKE '___'
	List<Book> findByBookNameNotLike(String pattern);

	// select * from booktab where btype=? and bcost < ?;
	List<Book> findByBookTypeEqualsAndBookCostLessThan(String bookType, Double bookCost);

	// single row
	Optional<Book> findByBookId(Integer bookId);

	// ORDER BY bname ASC
	List<Book> findAllByOrderByBookNameAsc();

	// ORDER BY bcost DESC
	List<Book> findAllByOrderByBookCostDesc();

	// ORDER BY btype ASC, bcost DESC
	List<Book> findAllByOrderByBookTypeAscBookCostDesc();

	// SELECT * FROM booktab WHERE btype = 'Frontend' ORDER BY bcost DESC;
	List<Book> findByBookTypeOrderByBookCostDesc(String bookType);

	// SELECT * FROM booktab WHERE bauthor = 'hari';
	List<Book> findByAuthorIgnoreCase(String author);

	//SELECT * FROM booktab WHERE bcost BETWEEN 200 AND 500;
	List<Book> findByBookCostBetween(Double min, Double max);

}
