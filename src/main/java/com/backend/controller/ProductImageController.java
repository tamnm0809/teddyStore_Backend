package com.backend.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.ProductImage;
import com.backend.services.ProductImageService;

@RestController
@RequestMapping("/teddy-store")
@RequiredArgsConstructor
public class ProductImageController {

	private final ProductImageService productImageService;

	@GetMapping("/getAllImageProduct")
	public List<ProductImage> getAllImagePro() {
		return productImageService.getAllImageProduct();
	}
}
