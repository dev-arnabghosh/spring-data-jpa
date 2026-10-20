package com.app.arnab.runner;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.arnab.entity.Product;
import com.app.arnab.repo.ProductRepository;

@Component
public class ProductDataRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		Product pob = new Product();

		pob.setProdId(10);

		pob.setProdCode("PEN");

		// pob.setColors(Arrays.asList("RE", "GR", "BL")); // java 8 approach
		pob.setColors(List.of("RE", "GR", "BL")); // java 9 approach

		/************************************
		 * Different ways of SET Declaration
		 ************************************/
		// jdk-5 approach 1 - Mutable
//		Set<String> models = new LinkedHashSet<>();
//		models.add("M1");
//		models.add("LA");
//		models.add("SF");

		// jdk-5 approach 2 - Mutable
		// Slightly more overhead due to intermediate list creation
//		Set<String> models = new LinkedHashSet<>(Arrays.asList("M1", "LA", "SF"));

		// jdk-9 approach 1 - immutable
		// Attempting to call .add() or .remove() on this set will throw an
		// UnsupportedOperationException
//		Set<String> models = Set.of("M1", "LA", "SF");

		// jdk-9 approach 2 - mutable (Recommended)
//		Set<String> models = new LinkedHashSet<>(Set.of("M1", "LA", "SF"));

		pob.setModels(new LinkedHashSet<String>(Set.of("M1", "LA", "SF")));

		/************************************
		 * Different ways of MAP Declaration
		 ************************************/
		// jdk-5 approach - 1 mutable
//		Map<String, String> details = new LinkedHashMap<>();
//		details.put("D1", "ABC");
//		details.put("D2", "XYZ");

		// jdk-5 approach 2 - mutable
		// using Anonymous Inner Class
//		Map<String, String> details = new LinkedHashMap<>() {{
//			put("D1", "ABC");
//			put("D2", "XYZ");
//		}};

		// jdk-9 approach 1 - immutable
//		Map<String, String> details = Map.of("D1", "ABC", "D2", "XYZ");

		// jdk-9 approach 2 - immutable
//		Map<String, String> details = Map.ofEntries(
//				Map.entry("D1", "ABC"),
//				Map.entry("D1", "ABC")				
//		);

		// jdk-9 approach 3 - mutable
//		Map<String, String> details = new LinkedHashMap<>(Map.of(//
//				"D1", "ABC", //
//				"D2", "XYZ"//
//		));

		pob.setDetails(new LinkedHashMap<>(Map.of("D1", "ABC", "D2", "XYZ")));
		
		repo.save(pob);

	}

}
