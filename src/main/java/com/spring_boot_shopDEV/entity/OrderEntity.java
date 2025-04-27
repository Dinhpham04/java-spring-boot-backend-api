package com.spring_boot_shopDEV.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "java_order_001")
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int userId;

    @ManyToMany(mappedBy = "order")
    @ToString.Exclude
    private List<ProductEntity> products;
}
