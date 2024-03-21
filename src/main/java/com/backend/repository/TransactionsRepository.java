package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.Transactions;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, String>{

}
