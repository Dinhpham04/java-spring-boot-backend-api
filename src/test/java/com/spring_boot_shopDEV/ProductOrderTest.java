package com.spring_boot_shopDEV;

import com.spring_boot_shopDEV.entity.OrderEntity;
import com.spring_boot_shopDEV.entity.ProductEntity;
import com.spring_boot_shopDEV.repository.OrderRepository;
import com.spring_boot_shopDEV.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class ProductOrderTest {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    @Rollback(false)
    void manyToManyTest() {
        ProductEntity product1 = new ProductEntity();
        OrderEntity order1 = new OrderEntity();

        ProductEntity product2 = new ProductEntity();
        OrderEntity order2 = new OrderEntity();

        OrderEntity order3 = new OrderEntity();
        OrderEntity order4 = new OrderEntity();

        product1.setProductName("product01");
        product1.setProductPrice(new BigDecimal(30));
        product2.setProductName("product01");
        product2.setProductPrice(new BigDecimal(30));

        order1.setUserId(1);
        order2.setUserId(1);
        order3.setUserId(1);
        order4.setUserId(1);

        product1.setOrder(List.of(order1, order2));
        product2.setOrder(List.of(order3, order4));

        productRepository.save(product1);
        productRepository.save(product2);
    }
}
