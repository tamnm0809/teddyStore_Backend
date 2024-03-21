package com.backend.services;

import java.util.List;
import com.backend.model.Product;

public interface ProductService {
	Object getAllProduct(int page, int size);
	Object getAllProductActive();
	Object updateProduct(Product product);

	Object searchProductByName(String name);
}
