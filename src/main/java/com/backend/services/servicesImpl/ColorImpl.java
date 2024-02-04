package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Color;
import com.backend.repository.ColorRepository;
import com.backend.services.ColorService;

@Service
public class ColorImpl implements ColorService{
	
	@Autowired
	private ColorRepository colorRepository;

	@Override
	public List<Color> getAllColor() {
		return colorRepository.findAll();
	}

}
