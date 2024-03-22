package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
>>>>>>> 7bf7467e33583850fbbb56de3b2cdddeaf869bf1

import com.backend.model.Order;
import com.backend.services.OrderService;

@RestController
@RequestMapping("/teddy-store")
<<<<<<< HEAD
@CrossOrigin(value = "http://localhost:3000/")
=======
@CrossOrigin(value="http://localhost:3000/")
>>>>>>> 7bf7467e33583850fbbb56de3b2cdddeaf869bf1
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
