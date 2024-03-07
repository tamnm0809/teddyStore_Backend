package com.backend.services;

import java.util.List;

import com.backend.dto.ProductDTO;
import com.backend.model.Product;

public interface ProductService {

	public List<Product> getAllProduct();
	
	public List<ProductDTO> getAllProductDTO();

	public List<ProductDTO> getAllProductWhereThuBong();
	
	public List<ProductDTO> getAllProductWhereGauHoatHinh();
}
