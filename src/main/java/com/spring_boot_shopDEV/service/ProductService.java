package com.spring_boot_shopDEV.service;

import com.spring_boot_shopDEV.entity.ProductEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductEntity createProduct(ProductEntity product);

    List<ProductEntity> findAllProducts();
}


