package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.AccountInfor;
import com.backend.services.AccountInforService;

@RestController
@RequestMapping("/teddy-store")
@CrossOrigin(value="http://localhost:3000/")
public class AccountInforController {

	@Autowired
	private AccountInforService accountInforService;

	@GetMapping("/getAllAccountInfor")
	public List<AccountInfor> getAllAccountInfor() {
		return accountInforService.getAllAccountInfor();
	}
}
