package com.app.arnab.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.arnab.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	// SQL: select * from booktab where author like ?
//	@Query("SELECT b from Book b where b.author=?1")
	@Query("SELECT b from Book b where b.author=:author")
	List<Book> getBooksByAuthor(String author);

	// SQL: select * from booktab where author like ? or bcost > ?
	// @Query("SELECT b from Book b where b.author like ?1 or b.bookCost > ?2")
//	@Query("SELECT b from Book b where b.author like :author or b.bookCost > :cost")
	@Query("SELECT b from Book b where b.bookCost > :cost or b.author like :author")
//	@Query("SELECT b from Book b where b.author like ?1 or b.bookCost > ?2 or b.bookType=?3")
	List<Book> getBooksByAuthorOrCost(String author, Double cost);

	// SQL: select * from booktab where bid in (?,?,?)
//	@Query("SELECT b from Book b where b.bookId in (?1)")
	@Query("SELECT b from Book b where b.bookId in (:bookids)")
	List<Book> getBookIds(@Param("bookids") List<Integer> bIds);

}
