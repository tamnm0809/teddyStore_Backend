package com.backend.services.servicesImpl;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.backend.model.Product;
import com.backend.repository.ProductRepository;
import com.backend.services.ProductService;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {
    private final ProductRepository proRepository;

    @Override
    public Object getAllProduct(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return proRepository.findAllProduct(pageable);
    }

    @Override
    public Object getAllProductActive() {
        return proRepository.findAllByActive(true);
    }

    @Override
    public Object updateProduct(Product product) {
        proRepository.save(product);
        return "OK";
    }

    @Override
    public Object searchProductByName(String name) {
        return proRepository.findAllProductByName(name, PageRequest.of(0, 10));
    }

}
