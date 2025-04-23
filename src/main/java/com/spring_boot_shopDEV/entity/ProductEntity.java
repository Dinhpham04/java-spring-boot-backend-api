package com.spring_boot_shopDEV.entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductEntity {
    private Long id;
    private String productName;
    private BigDecimal productPrice;
}
