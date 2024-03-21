package com.backend.repository;
 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.DetailsProduct;

@Repository
public interface DetailsProductRepository extends JpaRepository<DetailsProduct, String>{
 @Query(value = "SELECT p.id, pr.name, c.color, s.size_no, COUNT(o.id) as purchases " +
                   "FROM DETAILS_PRODUCT p " +
                   "JOIN [ORDER] o ON o.id = p.id " +
                   "JOIN PRODUCT pr ON pr.id = p.id_pro " +
                   "JOIN SIZE s ON s.id = p.id " +
                   "JOIN COLOR c ON c.id = p.id " +
                   "GROUP BY p.id, pr.name, c.color, s.size_no", nativeQuery = true)
    List<Object[]> getProductDetails();


}
