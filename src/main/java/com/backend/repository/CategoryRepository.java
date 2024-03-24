package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    @Query("SELECT a FROM Category a ORDER BY a.id DESC LIMIT 1")
    Optional<Category> findLastCategory();
    @Query("SELECT c FROM Category c WHERE LOWER(c.name) LIKE %:name%")
    Page<Category> findAllByName(@Param("name") String name, Pageable pageable);

    @Query("SELECT c FROM Category c WHERE c.active = :active")
    List<Category> findAllByActive(@Param("active") Boolean active);
}
