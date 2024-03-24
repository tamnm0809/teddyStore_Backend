package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.model.Category;
import com.backend.payload.CategoryPayload;
import com.backend.services.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/teddy-store")
@RequiredArgsConstructor
@CrossOrigin(value="http://localhost:3000/")
public class CategoryController {

    private final CategoryService cateService;

    @GetMapping("/getAllCategory")
    public Object getAllCategory(@RequestParam("page") int page, @RequestParam("size") int size) {
        return cateService.getAllCategory(page, size);
    }
    @GetMapping("/getAllCategoryActive")
    public Object getAllCategoryActive(){
        return cateService.getAllCategoryActive();
    }

    @PostMapping("updateCategory")
    public Object updateCategory(@RequestBody CategoryPayload category) {
        return cateService.updateCategory(category.getId(), category.getName(), category.getActive());
    }

    @PostMapping("searchCategory")
    public Object searchCategory(@RequestBody CategoryPayload category) {
        return cateService.searchCategory(category.getName());
    }
}
