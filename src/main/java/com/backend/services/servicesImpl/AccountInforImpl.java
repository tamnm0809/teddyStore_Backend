package com.backend.services.servicesImpl;

import java.util.List;

import com.backend.util.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.AccountInfor;
import com.backend.repository.AccountInforRepository;
import com.backend.services.AccountInforService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountInforImpl implements AccountInforService{
	
	@Autowired
	private AccountInforRepository accountInforRepository;

	@Override
	public List<AccountInfor> getAllAccountInfor() {
		return accountInforRepository.findAll();
	}

	@Override
	public boolean isExistEmail(String email) {
		return accountInforRepository.findByEmail(email)
				.isPresent();
	}

	@Override
	@Transactional
	public void saveAccountInfor(AccountInfor accountInfor) {
		var lastAccInfo = accountInforRepository.findLastAccountInfor();
		if(lastAccInfo.isPresent()){
			accountInfor.setId(RandomUtil.getNextId(lastAccInfo.get().getId(), "IA"));
		}else {
			accountInfor.setId(RandomUtil.getNextId(null, "IA"));
		}
		accountInforRepository.save(accountInfor);
	}
}
