package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Discount;

@Repository
public interface DiscountRepository extends JpaRepository<Discount, String>{

}
