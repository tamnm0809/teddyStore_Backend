package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Discount;
import com.backend.services.DiscountService;

@RestController
@RequestMapping("/teddy-store")
public class DiscountController {

	@Autowired
	private DiscountService discountService;
	
	@GetMapping("/getAllDiscount")
	public List<Discount> getAllDisCount(){
		return discountService.getAllDiscount();
	}
}
