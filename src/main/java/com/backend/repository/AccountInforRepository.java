package com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.model.AccountInfor;

@Repository
public interface AccountInforRepository extends JpaRepository<AccountInfor, String> {

}
	