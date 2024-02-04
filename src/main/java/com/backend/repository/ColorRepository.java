package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, String>{

}
