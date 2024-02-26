package com.backend.services;

import java.util.List;

import com.backend.model.Account;

public interface LoginAthenticationService {

	public List<Account> getAllAccount();

	boolean authenticateAcc(String username, String password);
	public Account loginWithFacebook(Account acc);
	Account getInforByUsername(String username);
	boolean isExistId(String id);
	boolean isExistUsername(String username);
	boolean registerAccount(Account acc);
	String resetPassword(String email);
}
