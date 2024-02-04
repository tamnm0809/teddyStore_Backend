package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Discount;
import com.backend.repository.DiscountRepository;
import com.backend.services.DiscountService;

@Service
public class DiscountImpl implements DiscountService{

	@Autowired
	private DiscountRepository discountRepository;

	@Override
	public List<Discount> getAllDiscount() {
		return discountRepository.findAll();
	}
}
