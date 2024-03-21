package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/")
	public String a() {
		return "";
	}
	
	@GetMapping("/getAllProduct")
	public List<ProductDTO> getAllProduct(){
		return proService.getAllProductDTO();
	}
	
	@GetMapping("/getAllProductWhere-Thu-Bong")
	public List<ProductDTO> getProductWhereThuBong(){
		return proService.getAllProductWhereThuBong();
	}
	
	@GetMapping("/getAllProductWhere-Gau-Bong-Hoat-Hinh")
	public List<ProductDTO> getProductWhereGauHoatHinh(){
		return proService.getAllProductWhereGauHoatHinh();
	}
	@GetMapping("/getProductDetailID/{id}")
    public List<ProductDTO> getProductDetails(@PathVariable String id) {
        return proService.getProductDetailsById(id);
    }
}