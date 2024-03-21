package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Rate;
import com.backend.repository.RateRepository;
import com.backend.services.RateService;

@Service
public class RateImpl implements RateService{

	@Autowired
	private RateRepository rateRepository;

	@Override
	public List<Rate> getAllRate() {
		return rateRepository.findAll();
	}
}
