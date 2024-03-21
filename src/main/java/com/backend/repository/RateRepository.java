package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Rate;

@Repository
public interface RateRepository extends JpaRepository<Rate, String>{

}
