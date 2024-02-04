package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Color;
import com.backend.services.ColorService;

@RestController
@RequestMapping("/teddy-store")
public class ColorController {

	@Autowired
	private ColorService colorService;
	
	@GetMapping("/getAllColor")
	public List<Color> getAllColor(){
		return colorService.getAllColor();
	}
}
