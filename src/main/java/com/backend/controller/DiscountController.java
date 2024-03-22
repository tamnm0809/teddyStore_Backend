package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.DiscountDTO;
import com.backend.model.Discount;
import com.backend.services.DiscountService;

@RestController
@RequestMapping("/teddy-store")
@CrossOrigin(value="http://localhost:3000/")
public class DiscountController {

	@Autowired
	private DiscountService discountService;
	
	@GetMapping("/getAllDiscount")
	public List<Discount> getAllDisCount(){
		return discountService.getAllDiscount();
	}
	@GetMapping("/getDiscount/{id}")
	public List<DiscountDTO> getDisCount(@PathVariable String id){
		return discountService.getDiscount(id);
	}
}
