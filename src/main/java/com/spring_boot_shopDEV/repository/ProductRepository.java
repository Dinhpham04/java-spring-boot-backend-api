package com.spring_boot_shopDEV.repository;

import com.spring_boot_shopDEV.entity.ProductEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository {
    ProductEntity createProduct(ProductEntity product);

    List<ProductEntity> findAllProducts();
}
