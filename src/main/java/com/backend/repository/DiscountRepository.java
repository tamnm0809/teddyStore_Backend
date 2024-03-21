package com.backend.repository;

import com.backend.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.Discount;

import java.util.Date;
import java.util.Optional;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String>{
    @Query("SELECT a FROM Discount a ORDER BY a.id DESC LIMIT 1")
    Optional<Discount> findLastDiscount();

    @Query("""
               SELECT d
               FROM Discount d
               JOIN FETCH d.detailsProduct dp
               JOIN FETCH dp.product
            """)
    Page<DiscountResponse> findAllDiscount(PageRequest pageRequest);

    @Query("""
               SELECT d
               FROM Discount d
               JOIN FETCH d.detailsProduct dp
               JOIN FETCH dp.product
               WHERE d.date_start >= :searchDateFrom AND d.date_end <= :searchDateTo
            """)
    Page<DiscountResponse> searchDiscountFromTo(java.sql.Date searchDateFrom, java.sql.Date searchDateTo, PageRequest pageRequest);


    interface DiscountResponse {
        String getId();
        Double getPrice_sale();
        String getDate_start();
        String getDate_end();
        DetailsProduct getDetailsProduct();

        interface DetailsProduct {
            String getId();
            Double getPrice();
            Product getProduct();

            interface Product {
                String getId();
                String getName();
            }
        }
    }
}
