package com.backend.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.backend.model.AccountInfo;
import com.backend.model.Address;
import com.backend.payload.RegisterPayload;
import com.backend.repository.AddressRepository;
import com.backend.services.AccountInforService;
import com.backend.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.model.Account;
import com.backend.services.LoginAthenticationService;

@RestController
@RequestMapping("/teddy-store")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoginAuthenticationController {
	private final LoginAthenticationService loginService;
	private final AccountInforService accountInforService;
	private final AddressRepository addressRepository;

	@GetMapping("/getAllAccount")
	public List<Account> getAllAccount() {
		return loginService.getAllAccount();
	}
	@PostMapping("reset-password/{email}")
	public void resetPassword(@PathVariable("email") String email) {
		loginService.resetPassword(email);
	}

	@PostMapping("/register")
	public Object register(@RequestBody RegisterPayload payload) {
		if (loginService.isExistUsername(payload.getUsername())) {
			return "USERNAME_EXISTED";
		}
		if (accountInforService.isExistEmail(payload.getEmail())) {
			return "EMAIL_EXISTED";
		}
		Account acc = new Account();
		acc.setUsername(payload.getUsername());
		acc.setPassword(payload.getPassword());
		acc.setDate_create(new Date());
		acc.setRole(false);
		acc.setActive(true);
		// Save account information
		AccountInfo accountInfor = new AccountInfo();
		accountInfor.setEmail(payload.getEmail());
		accountInfor.setName(payload.getName());
		accountInfor.setBirthday(payload.getDob());
		accountInfor.setGender(payload.getGender());
		accountInfor.setAvatar("NULL");
		Address address = new Address();
		var lastAddress = addressRepository.findLastAddress();
		if(lastAddress.isPresent()){
			address.setId(RandomUtil.getNextId(lastAddress.get().getId(), "AD"));
		}else {
			address.setId(RandomUtil.getNextId(null, "AD"));
		}
		address.setSub_address("NULL");
		address.setType_address("NULL");
		address.setAccount(acc);
		acc.setAddress(Set.of(address));

		accountInfor.setAccount(acc);
		loginService.registerAccount(acc);
		accountInforService.saveAccountInfor(accountInfor);
		return "OK";
	}
	@PostMapping("/login")
	public ResponseEntity<Account> login(@RequestBody Account acc) {
		String username = acc.getUsername();
		String password = acc.getPassword();

		if (loginService.authenticateAcc(username, password)) {
			Account authenticatedAcc = loginService.getInforByUsername(username);
			return new ResponseEntity<>(authenticatedAcc, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/login-facebook")
	public ResponseEntity<Account> LoginWithFacebook(@RequestBody Account acc, String username, String pasword) {
		if (loginService.authenticateAcc(username, pasword)) {
			Account authenticatedAcc = loginService.getInforByUsername(username);
			return new ResponseEntity<>(authenticatedAcc, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/logout")
	public ResponseEntity<Account> logout() {
		Account acc = new Account();
		return ResponseEntity.ok(acc);
	}

}