package com.spring_boot_shopDEV.entity.user;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "java_user_01")
@DynamicInsert // chỉ insert trường không null
@DynamicUpdate // chỉ update trường không null hoặc có giá trị
public class UserEntity { // phai co private key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tu dong tang gia tri va khong tao them bang
    private Long id; // userId

    @Column(columnDefinition = "varchar(255) comment 'user name'", nullable = false)
    private String userName;

    @Column(columnDefinition = "varchar(255) comment 'user email'", nullable = false, unique = true)
    private String userEmail;
}
