package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.backend.model.Order;
import com.backend.services.OrderService;

@RestController
@RequestMapping("/teddy-store")

@CrossOrigin(value="http://localhost:3000/")

public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@GetMapping("/getAllOrder")
	public List<Order> getAllOrder(){
		return orderService.getAllOder();
	}

	@PostMapping("/addNewOrder")
	public ResponseEntity<String> addNewOrder(@RequestBody Order order){
		orderService.addNewOrder(order);
		return ResponseEntity.ok("Save new Order successfully!");
	}
}
