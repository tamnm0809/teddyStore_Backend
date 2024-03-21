package com.backend.controller;

import java.util.List;

import com.backend.dto.SizeDTO;
import com.backend.payload.CategoryPayload;
import com.backend.payload.SizePayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.model.Size;
import com.backend.services.SizeService;

@RestController
@RequestMapping("/teddy-store")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SizeController {
    private final SizeService sizeService;
	@GetMapping("/getSizeBy/{productId}")
    public List<SizeDTO> getSizeById(@PathVariable String productId){
		return sizeService.getSizeWhereId(productId);
	}
	 @GetMapping("/getAllSize")
    public Object getAllSize(@RequestParam("page") int page, @RequestParam("size") int size) {
        return sizeService.getAllSize(page, size);
    }
    @GetMapping("/getAllSize")
    public Object getAllSize(){
        return sizeService.getAllSize();
    }
    @PostMapping("updateSize")
    public Object updateSize(@RequestBody SizePayload size) {
        return sizeService.updateSize(size.getIdSize(), size.getSizeNo());
    }

    @PostMapping("searchSize")
    public Object searchCategory(@RequestBody SizePayload size) {
        return sizeService.searchSize(size.getSizeNo());
    }
}