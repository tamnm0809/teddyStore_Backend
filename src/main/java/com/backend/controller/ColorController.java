package com.backend.controller;

import java.util.List;

import com.backend.payload.CategoryPayload;
import com.backend.payload.ColorPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.model.Color;
import com.backend.services.ColorService;

@RestController
@RequestMapping("/teddy-store")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ColorController {
	private final ColorService colorService;
	
	@GetMapping("/getAllColor")
	public Object getAllColor(@RequestParam("page") int page, @RequestParam("size") int size){
		return colorService.getAllColor(page, size);
	}

	@GetMapping("/getAllColor")
	public Object getAllColor(){
		return colorService.getAllColor();
	}

	@PostMapping("updateColor")
	public Object updateCategory(@RequestBody ColorPayload color) {
		return colorService.updateColor(color.getIdColor(), color.getColor());
	}

	@PostMapping("searchColor")
	public Object searchCategory(@RequestBody ColorPayload color) {
		return colorService.searchColor(color.getColor());
	}
}
