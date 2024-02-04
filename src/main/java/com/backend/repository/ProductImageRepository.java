package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, String>{

}
