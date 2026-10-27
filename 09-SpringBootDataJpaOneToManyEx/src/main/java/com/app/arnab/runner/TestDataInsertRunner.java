package com.app.arnab.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Model;
import com.app.arnab.entity.Product;
import com.app.arnab.repo.ModelRespository;
import com.app.arnab.repo.ProductRepository;

@Component
public class TestDataInsertRunner implements CommandLineRunner {

	@Autowired
	private ModelRespository mrepo;

	@Autowired
	private ProductRepository prepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Model m1 = new Model(1012, "XYZ-A", "4GB-128GB-RED");
		Model m2 = new Model(1013, "XYZ-B", "6GB-256GB-GREEN");
		Model m3 = new Model(1014, "MN-C", "12GB-512GB-PINK");
		Model m4 = new Model(1011, "MN-D", "2GB-64GB-BLACK");

		Product p1 = new Product(10, "ABCD-XYZ", Arrays.asList(m1, m2));
		Product p2 = new Product(11, "ABCD-MN", Arrays.asList(m3, m4));
		
		mrepo.saveAll(List.of(m1, m2, m3, m4));
		prepo.saveAll(List.of(p1, p2));

	}

}
