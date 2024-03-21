package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.DetailsProduct;
import com.backend.repository.DetailsProductRepository;
import com.backend.services.DetailsProductService;

@Service
public class DetailsProductImpl implements DetailsProductService {
	
	@Autowired
	private DetailsProductRepository detailsProductRepository;
	
	@Override
	public List<DetailsProduct> getAllDetailsProduct() {
		return detailsProductRepository.findAll();
	}

}
