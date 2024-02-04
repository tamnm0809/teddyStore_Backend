package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String>{

}
