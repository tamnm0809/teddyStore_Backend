//package com.backend.controller;
//
//import java.util.List;
//
//import com.backend.dto.CartDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//=======
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//>>>>>>> 7bf7467e33583850fbbb56de3b2cdddeaf869bf1
//
//import com.backend.model.Cart;
//import com.backend.services.CartService;
//
//@RestController
//@RequestMapping("/teddy-store")
//@CrossOrigin(value="http://localhost:3000/")
//public class CartController {
//
//	@Autowired
//	private CartService cartService;
//	
//	@GetMapping("/getAllCart/{id}")
//	public List<CartDTO> getAllCart(@PathVariable String id){
//		return cartService.getAllCart(id);
//	}
//
//	@DeleteMapping("/delete-cart/{id}")
//	ResponseEntity<?> doDeleteCart(@PathVariable String id){
//		cartService.deleteCart(id);
//		return ResponseEntity.ok("Delete successfully!");
//	}
//}
