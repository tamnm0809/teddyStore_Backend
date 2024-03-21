package com.backend.repository;

import com.backend.model.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.Color;

import java.util.List;
import java.util.Optional;

@Repository
public interface ColorRepository extends JpaRepository<Color, String>{
    @Query("SELECT a FROM Color a ORDER BY a.id DESC LIMIT 1")
    Optional<Color> findLastColor();
    @Query("SELECT c FROM Color c WHERE LOWER(c.color) LIKE %:color%")
    Page<Color> findAllByName(String color, Pageable pageable);
}
