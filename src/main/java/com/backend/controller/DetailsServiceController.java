package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.DetailsService;
import com.backend.services.DetailsServiceService;

@RestController
@RequestMapping("/teddy-store")
public class DetailsServiceController {

	@Autowired
	private DetailsServiceService detailsServiceService;

	@GetMapping("/getAllDetailsService")
	public List<DetailsService> getAllDetailsService() {
		return detailsServiceService.getAllDetailsService();
	}
}
