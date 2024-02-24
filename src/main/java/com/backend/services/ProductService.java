package com.backend.services;

import java.util.List;

import com.backend.dto.ProductDTO;
import com.backend.model.Product;

public interface ProductService {

	public List<Product> getAllProduct();
	
	List<ProductDTO> getAllProductDTO();
	
//	public List<Object[]> getAllProductsObject();
}
