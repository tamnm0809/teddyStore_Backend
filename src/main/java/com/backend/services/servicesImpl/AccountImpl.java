package com.backend.services.servicesImpl;

import java.util.List;

import com.backend.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Account;
import com.backend.services.AccountService;

@Service
public class AccountImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();

    }

    @Override
    public boolean authenticateAcc(String username, String password) {
        Account acc = accountRepository.findByUsername(username);
        return acc != null && acc.getPassword().equals(password);
    }

    @Override
    public Account getInfoByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Account loginWithFacebook(Account acc) {
        return accountRepository.save(acc);
    }

}
