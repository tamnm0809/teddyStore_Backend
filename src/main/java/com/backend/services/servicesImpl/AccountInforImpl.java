package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.AccountInfor;
import com.backend.repository.AccountInforRepository;
import com.backend.services.AccountInforService;

@Service
public class AccountInforImpl implements AccountInforService{
	
	@Autowired
	private AccountInforRepository accountInforRepository;

	@Override
	public List<AccountInfor> getAllAccountInfor() {
		return accountInforRepository.findAll();
	}

}
