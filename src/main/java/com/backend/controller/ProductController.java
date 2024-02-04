package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Product;
import com.backend.services.ProductService;

@RestController
@RequestMapping("/teddy-store")
public class ProductController {

	@Autowired
	private ProductService proService;
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct(){
		return proService.getAllProduct();
	}
}
