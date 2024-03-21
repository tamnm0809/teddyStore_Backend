package com.backend.services;

import java.util.List;

import com.backend.model.AccountInfor;

public interface AccountInforService {

	public List<AccountInfor> getAllAccountInfor();
	boolean isExistEmail(String email);

	void saveAccountInfor(AccountInfor accountInfor);
}
