package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.model.Account;

import java.util.Optional;

@Repository
public interface LoginAuthenticationRepository extends JpaRepository<Account, String>{
	Account findByUsername(String username);

	@Query("SELECT a FROM Account a ORDER BY a.id DESC LIMIT 1")
	Optional<Account> findLastAccount();

	@Query("""
            		SELECT a
            		FROM Account a
            		INNER JOIN a.accountInfors ai
            		WHERE ai.email = :email
            """)
	Optional<Account> findByEmail(String email);
}
