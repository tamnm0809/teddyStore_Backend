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
//	@Override
//    public List<Object[]> getAllProductsObject() {
//        return proRepository.findAllProductsWithCategory();
//    }

	private List<ProductDTO> convertToObjectDTO(List<Object[]> results) {
		List<ProductDTO> productDetailsDTOList = new ArrayList<>();

		for (Object[] result : results) {
			ProductDTO productDetailsDTO = new ProductDTO();
			productDetailsDTO.setId((String) result[0]);
			productDetailsDTO.setName((String) result[1]);
			productDetailsDTO.setPrice((double) result[2]);
			productDetailsDTO.setImg_url((String) result[3]);
//            productDetailsDTO.setSize((String) result[4]);

			productDetailsDTOList.add(productDetailsDTO);
		}

		return productDetailsDTOList;
	}

	public List<ProductDTO> getAllProductDTO() {
		List<Object[]> results = proRepository.findAllProducts();
		return convertToObjectDTO(results);
	}

}
