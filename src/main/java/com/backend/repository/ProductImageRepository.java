package com.backend.repository;

import com.backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.ProductImage;

import java.util.Optional;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String>{
    @Query("SELECT a FROM ProductImage a ORDER BY a.id DESC LIMIT 1")
    Optional<ProductImage> findLastProductImage();
}
