package com.backend.repository;

import com.backend.model.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.DetailsProduct;

import java.util.Optional;

@Repository
public interface DetailsProductRepository extends JpaRepository<DetailsProduct, String>{
    @Query("SELECT a FROM DetailsProduct a ORDER BY a.id DESC LIMIT 1")
    Optional<DetailsProduct> findLastDetailsProduct();
}
