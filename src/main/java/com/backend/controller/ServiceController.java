package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Service;
import com.backend.services.ServiceService;

@RestController
@RequestMapping("/teddy-store")
public class ServiceController {

	@Autowired
	private ServiceService service;
	
	@GetMapping("/getAllService")
	public List<Service> getAllService(){
		return service.getAllService();
	}
}
