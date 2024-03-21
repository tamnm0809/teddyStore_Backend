package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.DetailsOrder;

@Repository
public interface DetailsOrderRepository extends JpaRepository<DetailsOrder, String>{

}
