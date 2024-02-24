package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.AccountInfor;

import java.util.Optional;

@Repository
public interface AccountInforRepository extends JpaRepository<AccountInfor, String> {
    Optional<AccountInfor> findByEmail(String email);

    @Query("SELECT a FROM AccountInfor a ORDER BY a.id DESC LIMIT 1")
    Optional<AccountInfor> findLastAccountInfor();
}
	