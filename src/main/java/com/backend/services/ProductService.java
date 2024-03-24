package com.backend.services;

import java.util.List;

import com.backend.dto.ProductDTO; 
import com.backend.model.Product;

public interface ProductService {
	
//	Object getAllProduct(int page, int size);
//	Object getAllProductActive();
	Object updateProduct(Product product);

//	Object searchProductByName(String name);

	public List<Product> getAllProduct();
	
	public List<ProductDTO> getAllProductDTO();

	public List<ProductDTO> getAllProductWhereThuBong();
	
	public List<ProductDTO> getAllProductWhereGauHoatHinh();

    public List<ProductDTO> getProductDetailsById(String id);
	 

}
