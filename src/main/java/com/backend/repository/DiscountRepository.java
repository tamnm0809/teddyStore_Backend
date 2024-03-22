package com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String>{
    @Query(value = "SELECT dp.price, dc.price_sale, dp.quantity " +
    "FROM DISCOUNT dc   " +
    "JOIN DETAILS_PRODUCT dp ON dc.id_dt_pro = dp.id " +
    "WHERE dp.id = :id",nativeQuery=true)
    List<Object[]> getDiscount(@Param("id") String id);

}
