package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.ProductImage;
import com.backend.services.ProductImageService;

@RestController
@RequestMapping("/teddy-store")
public class ProductImageController {

	@Autowired
	private ProductImageService productImageService;

	@GetMapping("/getAllImageProduct")
	public List<ProductImage> getAllImagePro() {
		return productImageService.getAllImageProduct();
	}
}
