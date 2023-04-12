package com.eg.swa.ntier.shopping.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eg.swa.ntier.shopping.model.Product;
import com.eg.swa.ntier.shopping.repository.ProductRepository;
import com.eg.swa.ntier.shopping.service.ProductService;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

   


}
