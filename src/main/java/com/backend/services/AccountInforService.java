package com.backend.services;

import java.util.List;

import com.backend.model.AccountInfo;

public interface AccountInforService {

	public List<AccountInfo> getAllAccountInfor();
	boolean isExistEmail(String email);

	void saveAccountInfor(AccountInfor accountInfor);
}
