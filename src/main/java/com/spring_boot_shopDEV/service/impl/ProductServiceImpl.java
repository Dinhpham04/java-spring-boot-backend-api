package com.spring_boot_shopDEV.service.impl;

import com.spring_boot_shopDEV.entity.ProductEntity;
import com.spring_boot_shopDEV.repository.ProductRepository;
import com.spring_boot_shopDEV.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.createProduct(product);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAllProducts();
    }
}
