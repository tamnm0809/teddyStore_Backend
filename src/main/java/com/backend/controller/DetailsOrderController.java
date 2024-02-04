package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.DetailsOrder;
import com.backend.services.DetailsOrderService;

@RestController
@RequestMapping("/teddy-store")
public class DetailsOrderController {

	@Autowired
	private DetailsOrderService detailsOrderService;
	
	@GetMapping("/getAllDetailsOrder")
	public List<DetailsOrder> getAllDetailsOrder(){
		return detailsOrderService.getAllDetailsOrder();
	}
}
