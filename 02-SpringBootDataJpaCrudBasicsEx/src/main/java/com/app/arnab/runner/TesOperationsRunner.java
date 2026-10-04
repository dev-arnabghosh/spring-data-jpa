package com.app.arnab.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Product;
import com.app.arnab.exception.ProductNotFoundException;

import com.app.arnab.repo.ProductRepository;

@Component
public class TesOperationsRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {

		// TODO Auto-generated method stub

		// Prints the runtime implementation class generated/provided by Spring Data JPA.
		// This is useful to understand which implementation Spring injects for the repository.
		System.out.println("Dynamic Proxy Class Name:");
		System.out.println(repo.getClass().getName());
		System.out.println("/==================================================/");
		
		// Create Product objects in memory.
		// These objects can later be persisted into the database using save() or saveAll().
		Product p1 = new Product(10, "P1", 100.00);
		Product p2 = new Product(11, "P2", 200.00);
		Product p3 = new Product(12, "P3", 300.00);

		// save() is used to save a single entity into the database.
		System.out.println("Saving using save() method");
		repo.save(p1);
		repo.save(p2);
		repo.save(p3);

		// Display all records to verify the database state after save().
		System.out.println("/==================================================/");
		repo.findAll().forEach(System.out::println);

		// saveAll() is used to save multiple entities at once.
		// Arrays.asList() converts the Product objects into a List.
		System.out.println("/==================================================/");

		Product p4 = new Product(13, "P4", 400.00);
		Product p5 = new Product(14, "P5", 500.00);
		Product p6 = new Product(15, "P6", 600.00);
		Product p7 = new Product(16, "P7", 700.00);

		System.out.println("Saving using saveAll() method");
		repo.saveAll(Arrays.asList(p4, p5, p6, p7));

		// Display all records to verify the database state after saveAll().
		// findAll() fetches all Product records from the database.
		// The return type is Iterable<Product>.

		// JDK 1.5 enhanced for loop.
		// Iterates through every Product object returned by findAll().
		System.out.println("/==================================================/");
		System.out.println("Fetching all the records:");
		Iterable<Product> products = repo.findAll();
		for (Product p : products) {
			System.out.println(p);
		}

		System.out.println("/==================================================/");

		// JDK 1.8 Lambda Expression + Iterable.forEach() default method.
		// Performs the given operation for every Product object.
		System.out.println("forEach with Lambda Expression");
		products.forEach(product -> System.out.println(product));

		System.out.println("/==================================================/");

		// JDK 1.8 Method Reference.
		// System.out::println is a shorter form of product -> System.out.println(product).
		System.out.println("forEach with Method Reference");
		products.forEach(System.out::println);

		System.out.println("/==================================================/");

		// existsById() checks whether a record with the given ID exists.
		// Returns true if the record exists; otherwise returns false.
		System.out.println("are these record exist?");
		System.out.println("Record with pid=11: " + repo.existsById(11));
		System.out.println("Record with pid=55: " + repo.existsById(55));

		System.out.println("/==================================================/");

		// count() returns the total number of Product records present in the database.
		System.out.println("how many records are present?");
		System.out.println(repo.count());

		System.out.println("/==================================================/");
		System.out.println("Fetching specific product by id:");
		// findById() fetches a single Product based on its ID.
		// It returns Optional<Product> because the requested record may or may not exist.
		Optional<Product> opt = repo.findById(11);

		// isPresent() checks whether the Optional contains a Product object.
		if (opt.isPresent()) {
			Product p = opt.get();
			System.out.println(p);
		} else {
			System.out.println("Object not found!");
		}

		opt = repo.findById(99);

		// isEmpty() checks whether the Optional does NOT contain a Product object.
		// isEmpty() was introduced in Java 11.
		if (opt.isEmpty()) {
			System.out.println("Object is not present!");
		} else {
			Product p = opt.get();
			System.out.println(p);
		}

		System.out.println("/==================================================/");

		// findById() returns Optional<Product>.
		// orElseThrow() returns the Product if present.
		// If the Product is not present, it throws the specified exception.
		System.out.println("Usage of orElseThrow() method");
		Product p = repo.findById(13).orElseThrow(
				() -> new ProductNotFoundException("NOT EXIST") // Supplier
		);
		System.out.println(p);

		System.out.println("/==================================================/");

		// findAllById() fetches multiple Product records based on the supplied IDs.
		// If an ID does not exist, it is simply ignored.
		// The result contains only the records that are actually found.
		System.out.println("Fetching specific products:");
		Iterable<Product> specificProducts = repo.findAllById(Arrays.asList(11, 15, 13, 10));

		specificProducts.forEach(System.out::println);

		System.out.println("/==================================================/");

		// deleteById() deletes the Product associated with the given ID.
		// If the ID does not exist, behavior depends on the Spring Data version.
		// In current Spring Data versions, a missing ID is silently ignored.
		System.out.println("Deleting specific products");
		repo.deleteById(16);
		repo.deleteById(99);

		// Display all records to verify the database state after deleteById().
		System.out.println("/==================================================/");
		System.out.println("After deleting specific products:");
		repo.findAll().forEach(System.out::println);

		System.out.println("/==================================================/");

		// First find the Product using its ID.
		// orElseThrow() ensures that a custom exception is thrown if the Product does not exist.
		System.out.println("If product is available");
		Integer id = 15;
		Product productToDelete = repo.findById(id).orElseThrow(
				() -> new ProductNotFoundException(
						String.format("-- %s NOT HAVING %d --", Product.class.getName(), id)
				)
		);

		System.out.println("Product to delete: " + productToDelete);
		
		try {
			System.out.println("If product is not available");
			Integer id1 = 99;

			Product unavailableProduct = repo.findById(id1).orElseThrow(
					() -> new ProductNotFoundException(
							String.format("-- %s NOT HAVING %d --", Product.class.getName(), id1)
					)
			);
			
			// We can't delete it...
			repo.delete(unavailableProduct);
			
		} catch(ProductNotFoundException pde) {
			pde.printStackTrace();
		}
		
		// delete() deletes the entity object passed to it.
		// JPA follows the object-oriented approach: the entity object is passed for deletion.
		System.out.println("Deleting specific product using delete(Entity)");
		repo.delete(productToDelete);

		// Display all records to verify the database state after delete().
		System.out.println("/==================================================/");
		System.out.println("Available Products after Executing delete(Entity)");
		repo.findAll().forEach(System.out::println);		

		System.out.println("/==================================================/");

		// deleteAllById() deletes all entities whose IDs are supplied.
		// IDs that do not correspond to existing records are ignored in current versions.
		System.out.println("Deleting specific products using deleteAllById(Iterable)");
		repo.deleteAllById(Arrays.asList(10, 11));

		// Display all records to verify the database state after deleteAllById().
		System.out.println("/==================================================/");
		System.out.println("Available Products after Executing deleteAllById(Iterable)");
		repo.findAll().forEach(System.out::println);

		// findAllById() first fetches the entities corresponding to the supplied IDs.
		// deleteAll() then deletes all the fetched entity objects.
		System.out.println("/==================================================/");
		System.out.println("Deleting all products using deleteAll with given IDs");
		repo.deleteAll(
				repo.findAllById(Arrays.asList(13, 14))
		);

		// Display all records to verify the database state after deleteAll().
		System.out.println("/==================================================/");
		System.out.println("Available Products after Executing deleteAll(Iterable)");
		repo.findAll().forEach(System.out::println);

		// deleteAll() deletes all Product records from the database.
		// Use this carefully because it removes every Product entity.
		System.out.println("/==================================================/");
		System.out.println("Deleting all products using deleteAll");
		repo.deleteAll();
		// Display all records to verify that all Product records have been deleted.
		System.out.println("Available Products after Executing deleteAll()");
		System.out.println("Number of rows: " + repo.count());

	}

}