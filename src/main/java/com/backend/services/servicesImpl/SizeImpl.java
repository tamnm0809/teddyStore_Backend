package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Size;
import com.backend.repository.SizeRepository;
import com.backend.services.SizeService;

@Service
public class SizeImpl implements SizeService{
	
	@Autowired
	private SizeRepository sizeRepository;

	@Override
	public List<Size> getAllSize() {
		return sizeRepository.findAll();
	}

}
