package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.ProductDTO;
import com.backend.services.ProductService;

@RestController
@RequestMapping("/teddy-store")
@CrossOrigin(value="http://localhost:3000/")
public class ProductController {

	@Autowired
	private ProductService proService;
	
	@GetMapping("/getAllProduct")
	public List<ProductDTO> getAllProduct(){
		return proService.getAllProductDTO();
	}
}