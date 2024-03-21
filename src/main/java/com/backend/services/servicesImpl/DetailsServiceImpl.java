package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.DetailsService;
import com.backend.repository.DetailsServiceRepository;
import com.backend.services.DetailsServiceService;

@Service
public class DetailsServiceImpl implements DetailsServiceService{
	
	@Autowired
	private DetailsServiceRepository detailsServiceRepository;

	@Override
	public List<DetailsService> getAllDetailsService() {
		return detailsServiceRepository.findAll();
	}

}
