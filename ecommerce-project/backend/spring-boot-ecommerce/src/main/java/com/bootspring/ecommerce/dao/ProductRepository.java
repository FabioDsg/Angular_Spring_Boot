package com.bootspring.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootspring.ecommerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	

}
