package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.AccountInfo;
import com.backend.services.AccountInfoService;

@RestController
@RequestMapping("/teddy-store")
@CrossOrigin(value="http://localhost:3000/")
public class AccountInforController {

	@Autowired
	private AccountInfoService accountInforService;

	@GetMapping("/getAllAccountInfor")
	public List<AccountInfo> getAllAccountInfor() {
		return accountInforService.getAllAccountInfo();
	}
}
