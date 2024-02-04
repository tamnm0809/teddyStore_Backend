package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.repository.ServiceRepository;
import com.backend.services.ServiceService;

@Service
public class ServiceImpl implements ServiceService{

	@Autowired
	private ServiceRepository serviceRepository;

	@Override
	public List<com.backend.model.Service> getAllService() {
		return serviceRepository.findAll();
	}
}
