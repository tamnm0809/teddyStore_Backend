package com.backend.controller;

import java.text.ParseException;
import java.util.List;

import com.backend.payload.DiscountPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.model.Discount;
import com.backend.services.DiscountService;

@RestController
@RequestMapping("/teddy-store")
@RequiredArgsConstructor
@CrossOrigin("*")
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
}
