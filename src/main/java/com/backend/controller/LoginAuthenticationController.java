package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Account;
import com.backend.services.LoginAthenticationService;

@RestController
@RequestMapping("/teddy-store")
public class LoginAuthenticationController {

	@Autowired
	private LoginAthenticationService loginService;

	@GetMapping("/getAllAccount")
	public List<Account> getAllAccount() {
		return loginService.getAllAccount();
	}

	@PostMapping("/login")
	public Boolean login(@RequestBody Account acc) {
		String username = acc.getUsername();
		String password = acc.getPassword();

		if (loginService.authenticateAcc(username, password)) {
			/*
			 * Login Succesfully
			 */
			return true;
		} else {
			/*
			 * Login Failed
			 */
			return false;
		}
	}
	
	@PostMapping("/logout")
	public Boolean logout() {
		new Account();
		return true;
	}
	
}
