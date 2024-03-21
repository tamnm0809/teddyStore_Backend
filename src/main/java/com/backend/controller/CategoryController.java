package com.backend.controller;

import java.util.List;

import com.backend.payload.CategoryPayload;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.backend.model.Category;
import com.backend.services.CategoryService;

@RestController
@RequestMapping("/teddy-store")
@RequiredArgsConstructor
@CrossOrigin("*")
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
