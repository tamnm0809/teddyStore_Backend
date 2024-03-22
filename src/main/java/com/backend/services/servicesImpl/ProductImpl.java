package com.backend.services.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.ProductDTO; 
import com.backend.model.Product;
import com.backend.repository.ProductRepository;
import com.backend.services.ProductService;

@Service
public class ProductImpl implements ProductService {

	@Autowired
	ProductRepository proRepository;

	@Override
	public List<Product> getAllProduct() {
		return proRepository.findAll();
	}

	private List<ProductDTO> convertToProductsDTO(List<Object[]> results) {
		List<ProductDTO> productDetailsDTOList = new ArrayList<>();

		for (Object[] result : results) {
			ProductDTO productDetailsDTO = new ProductDTO();
			productDetailsDTO.setId((String) result[0]);
			productDetailsDTO.setName((String) result[1]);
			productDetailsDTO.setImg_url((String) result[2]);

			productDetailsDTOList.add(productDetailsDTO);
		}

		return productDetailsDTOList;
	}

	public List<ProductDTO> getAllProductDTO() {
		List<Object[]> results = proRepository.findAllProducts();
		return convertToProductsDTO(results);
	}
	
	public List<ProductDTO> getAllProductWhereThuBong() {
		List<Object[]> results = proRepository.findAllWhereThuBong();
		return convertToProductsDTO(results);
	}

	public List<ProductDTO> getAllProductWhereGauHoatHinh() {
		List<Object[]> results = proRepository.findAllWhereGauHoatHinh();
		return convertToProductsDTO(results);
	}

	// private List<ProductsDTO> convertToProductDetailsDTO(List<Object[]> results) {
	// 	List<ProductsDTO> productsDTOList = new ArrayList<>();

	// 	for (Object[] result : results) {
	// 		ProductsDTO productssDTO = new ProductsDTO();
	// 		productssDTO.setId((String) result[0]);
	// 		productssDTO.setName((String) result[1]);
	// 		productssDTO.setImg_url((String) result[2]);
	// 		productssDTO.setPrice((Integer) result[3]);
	// 		productssDTO.setPrice_sale((Integer) result[4]);
	// 		productssDTO.setColor((String) result[5]);
	// 		productssDTO.setSize_no((String) result[6]);
	// 		productssDTO.setQuantity((Integer) result[7]); 

	// 		productsDTOList.add(productssDTO);
	// 	}

	// 	return productsDTOList;
	// }

	 
	public List<ProductDTO> getProductDetailsById(String id) {
		List<Object[]> results = proRepository.getProductDetails(id);
		return convertToProductsDTO(results);
	}

	
	 
}
