package com.backend.repository;

import com.backend.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.Size;

import java.util.List;
import java.util.Optional;

@Repository
public interface SizeRepository extends JpaRepository<Size, String>{
    @Query("SELECT a FROM Size a ORDER BY a.id DESC LIMIT 1")
    Optional<Size> findLastSize();
    @Query("SELECT c FROM Size c WHERE LOWER(c.size_no) LIKE %:sizeNo%")
    Page<Size> findAllByName(String sizeNo, Pageable pageable);
}
