package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.backend.model.DetailsService;

@RequestMapping
public interface DetailsServiceRepository extends JpaRepository<DetailsService, String>{

}
