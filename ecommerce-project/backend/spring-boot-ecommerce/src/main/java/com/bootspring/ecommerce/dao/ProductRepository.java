package com.bootspring.ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootspring.ecommerce.entity.Product;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Page <Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
	
	// Search by name
	Page <Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

}
