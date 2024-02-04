package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Size;
import com.backend.services.SizeService;

@RestController
@RequestMapping("/teddy-store")
public class SizeController {

	@Autowired
	private SizeService sizeService;
	
	@GetMapping("/getAllSize")
	public List<Size> getAllSize(){
		return sizeService.getAllSize();
	}
}
