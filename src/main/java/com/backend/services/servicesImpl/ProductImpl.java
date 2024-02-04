package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Product;
import com.backend.repository.ProductRepository;
import com.backend.services.ProductService;

@Service
public class ProductImpl implements ProductService{
	
	@Autowired
	ProductRepository proRepository;

	@Override
	public List<Product> getAllProduct() {
		return proRepository.findAll();
	}

	
}
