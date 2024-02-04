package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Rate;
import com.backend.services.RateService;

@RestController
@RequestMapping("/teddy-store")
public class RateController {

	@Autowired
	private RateService rateService;
	
	@GetMapping("/getAllRate")
	public List<Rate> getAllRate(){
		return rateService.getAllRate();
	}
}
