package com.app.arnab.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.arnab.entity.Product;

public interface ProductRepository 
	extends CrudRepository<Product, Integer> {

}
