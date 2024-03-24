package com.backend.services.servicesImpl;

import java.util.List;

import com.backend.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.model.Category;
import com.backend.repository.CategoryRepository;
import com.backend.services.CategoryService;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
	 private final CategoryRepository cateRepository;

	 @Override
	    public Object getAllCategory(int page, int size) {
	        Pageable pageable = PageRequest.of(page, size);
	        return cateRepository.findAll(pageable);
	    }

	    @Override
	    public Object updateCategory(String id, String name, Boolean active) {
	        // N?u id t?n t?i th? update, kh�ng t?n t?i th? t?o m?i
	        var category = cateRepository.findById(id);

	        // ki?m tra xem category c� t?n t?i kh�ng
	        if (category.isPresent()) {
	            category
	                    .get()
	                    .setName(name);
	            category
	                    .get()
	                    .setActive(active);
	            cateRepository.save(category.get());
	        } else {

	            // t?o m?i category
	            var newCategory = new Category();
	            var lastCategory = cateRepository.findLastCategory();

	            // l?y id c?a category cu?i c�ng v� t?o id m?i
	            if (lastCategory.isPresent()) {
	                newCategory.setId(RandomUtil.getNextId(lastCategory
	                                                               .get()
	                                                               .getId(), "CA"));
	            } else {
	                newCategory.setId(RandomUtil.getNextId(null, "CA"));
	            }
	            newCategory.setName(name);
	            newCategory.setActive(Boolean.TRUE);
	            cateRepository.save(newCategory);
	        }
	        return "OK";
	    }

	    @Override
	    public Object searchCategory(String name) {
	        return cateRepository.findAllByName(name, PageRequest.of(0, 10));
	    }

	    @Override
	    public Object getAllCategoryActive() {
	        return cateRepository.findAllByActive(Boolean.TRUE);
	    }

}
