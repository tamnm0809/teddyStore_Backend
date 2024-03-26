package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.ParseException;
import com.backend.dto.DiscountDTO;
import com.backend.model.Discount;
import com.backend.payload.DiscountPayload;
import com.backend.services.DiscountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/teddy-store")
@RequiredArgsConstructor
@CrossOrigin(value="http://localhost:3000/")
public class DiscountController {


	private final DiscountService discountService;
	
	@GetMapping("/getAllDiscount")
	public Object getAllDisCount(@RequestParam("page") int page, @RequestParam("size") int size){
		return discountService.getAllDiscount(page, size);
	}

	@PostMapping("/updateDiscount")
	public Object updateDiscount(@RequestBody DiscountPayload discount) throws ParseException {
		return discountService.updateDiscount(discount.getId(), discount.getDiscount(), discount.getStartDate(), discount.getEndDate(), discount.getProductId());
	}

	@DeleteMapping("deleteDiscount/{id}")
	public Object deleteDiscount(@PathVariable String id) {
		return discountService.deleteDiscount(id);
	}

	@PostMapping("searchDiscount")
	public Object searchDiscount(@RequestBody DiscountPayload discountPayload) {
		return discountService.searchDiscount(discountPayload.getSearchDateFrom(), discountPayload.getSearchDateTo());
	}
	
//	@GetMapping("/getAllDiscount")
//	public List<Discount> getAllDisCount(){
//		return discountService.getAllDiscount();
//	}
//	@GetMapping("/getDiscount/{id}")
//	public List<DiscountDTO> getDisCount(@PathVariable String id){
//		return discountService.getDiscount(id);
//	}
}
