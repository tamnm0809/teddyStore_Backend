package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Account;

@Repository
public interface LoginAuthenticationRepository extends JpaRepository<Account, String>{
	Account findByUsername(String username);
}
