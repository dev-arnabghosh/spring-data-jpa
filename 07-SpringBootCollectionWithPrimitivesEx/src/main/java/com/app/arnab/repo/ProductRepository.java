package com.app.arnab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.arnab.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}
