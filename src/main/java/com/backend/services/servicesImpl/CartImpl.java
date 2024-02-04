package com.backend.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.model.Cart;
import com.backend.repository.CartRepository;
import com.backend.services.CartService;

@Service
public class CartImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public List<Cart> getAllCart() {
		return cartRepository.findAll();
	}

}
