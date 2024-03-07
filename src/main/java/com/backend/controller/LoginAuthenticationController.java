package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Account;
import com.backend.services.LoginAthenticationService;

@RestController
@RequestMapping("/teddy-store")
@CrossOrigin("http://localhost:3000/")
public class LoginAuthenticationController {

	@Autowired
	private LoginAthenticationService loginService;

	@GetMapping("/getAllAccount")
	public List<Account> getAllAccount() {
		return loginService.getAllAccount();
	}

	@PostMapping("/login")
	public ResponseEntity<Account> login(@RequestBody Account acc) {
	    String username = acc.getUsername();
	    String password = acc.getPassword();

	    if (loginService.authenticateAcc(username, password)) {
	        // Đăng nhập thành công, trả về đối tượng Account hoặc một đối tượng khác nếu cần
	        Account authenticatedAcc = loginService.getInforByUsername(username); // Thay thế bằng phương thức thích hợp
	        return new ResponseEntity<>(authenticatedAcc, HttpStatus.OK);
	    } else {
	        /*
	         * Đăng nhập thất bại
	         */
	        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	    }
	}

	@PostMapping("/logout")
	public Boolean logout() {
		new Account();
		return true;
	}
	
}
