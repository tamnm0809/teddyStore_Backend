package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Cart;
import com.backend.services.CartService;

@RestController
@RequestMapping("/teddy-store")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@GetMapping("/getAllCart")
	public List<Cart> getAllCart(){
		return cartService.getAllCart();
	}
}
