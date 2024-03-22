package com.backend.services;

import java.util.List;

import com.backend.model.DetailsOrder;

public interface DetailsOrderService {

	public List<DetailsOrder> getAllDetailsOrder();

	public DetailsOrder addNewDetailOrder(DetailsOrder detailsOrder);
}
