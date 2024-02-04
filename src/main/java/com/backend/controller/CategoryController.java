package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Category;
import com.backend.services.CategoryService;

@RestController
@RequestMapping("/teddy-store")
public class CategoryController {

	@Autowired
	private CategoryService cateService;
	
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory(){	
		return cateService.getAllCategory();
	}
}
