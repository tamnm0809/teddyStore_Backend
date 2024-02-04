package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, String>{

}
