package com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	@Query("SELECT p.id, p.name, dp.price, c.img_url FROM Product p "
			+ "JOIN p.productImages c "
			+ "JOIN p.detailsProduct dp "
			+ "ORDER BY RAND() LIMIT 1")
    List<Object[]> findAllProducts();
}
