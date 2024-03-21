package com.backend.services;

import java.util.List;

import com.backend.dto.DiscountDTO;
import com.backend.model.Discount;

public interface DiscountService {

	public List<Discount> getAllDiscount();
	public List<DiscountDTO> getDiscount(String id);
}
