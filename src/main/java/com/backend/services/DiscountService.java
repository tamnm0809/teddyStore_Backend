package com.backend.services;

import java.util.List;
import java.text.ParseException;
import com.backend.dto.DiscountDTO;
import com.backend.model.Discount;

public interface DiscountService {

	public List<Discount> getAllDiscount();
	public List<DiscountDTO> getDiscount(String id);
	

	 Object getAllDiscount(int page, int size);

	 Object updateDiscount(String id, Double discount, String startDate, String endDate, String productId) throws
																										   ParseException;

	 Object deleteDiscount(String id);

	 Object searchDiscount(String searchDateFrom, String searchDateTo);
}
