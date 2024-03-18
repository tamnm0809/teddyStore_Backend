package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Account;
import com.backend.repository.LoginAuthenticationRepository;
import com.backend.services.LoginAthenticationService;

@Service
public class LoginAuthenticationImpl implements LoginAthenticationService {

	@Autowired
	private LoginAuthenticationRepository loginRepository;

	@Override
	public List<Account> getAllAccount() {
		return loginRepository.findAll();

	}

	@Override
	public boolean authenticateAcc(String username, String password) {
		Account acc = loginRepository.findByUsername(username);
		return acc != null && acc.getPassword().equals(password);
	}
	
	@Override
	public Account getInforByUsername(String username) {
		return loginRepository.findByUsername(username);
	}

	@Override
	public Account loginWithFacebook(Account acc) {
        return loginRepository.save(acc);
	}

}
