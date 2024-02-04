package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.ProductImage;
import com.backend.repository.ProductImageRepository;
import com.backend.services.ProductImageService;

@Service
public class ProductImageImpl implements ProductImageService {

	@Autowired
	private ProductImageRepository productImageRepository;

	@Override
	public List<ProductImage> getAllImageProduct() {
		return productImageRepository.findAll();
	}

}
