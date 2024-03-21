package com.backend.services;

import java.text.ParseException;
import java.util.List;

import com.backend.model.Discount;

public interface DiscountService {

	 Object getAllDiscount(int page, int size);

	 Object updateDiscount(String id, Double discount, String startDate, String endDate, String productId) throws
																										   ParseException;

	 Object deleteDiscount(String id);

	 Object searchDiscount(String searchDateFrom, String searchDateTo);
}
