package com.app.arnab.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Product;
import com.app.arnab.repo.ProductRepository;

@Component
public class TesOperationsRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(repo.getClass().getName());

		Product p1 = new Product(10, "P1", 200.00);
		Product p2 = new Product(11, "P2", 300.00);
		Product p3 = new Product(12, "P3", 400.00);

		repo.save(p1);
		repo.save(p2);
		repo.save(p3);

		repo.saveAll(Arrays.asList(p1, p2, p3));

		Iterable<Product> products = repo.findAll();

		// jdk-1.5 forEach loop
		for (Product p : products) {
			System.out.println(p);
		}
		System.out.println("/==================================================/");
		// jdk-1.8 Lambda Expression + Default method
		products.forEach(product -> System.out.println(product));

		System.out.println("/==================================================/");
		// jdk-1.8 method reference
		products.forEach(System.out::println);

		System.out.println("/==================================================/");
		System.out.println(repo.existsById(11));
		System.out.println(repo.existsById(55));

		System.out.println("/==================================================/");
		System.out.println(repo.count());
	}

}
