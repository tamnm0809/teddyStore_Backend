package com.backend.repository;

import com.backend.model.Address;
import com.backend.model.Color;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
    @Query("SELECT a FROM Address a ORDER BY a.id DESC LIMIT 1")
    Optional<Color> findLastAddress();

}