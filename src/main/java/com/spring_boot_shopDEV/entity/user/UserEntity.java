package com.spring_boot_shopDEV.entity.user;

import com.spring_boot_shopDEV.entity.feed.FeedEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "java_user_01")
@DynamicInsert // chỉ insert trường không null
@DynamicUpdate // chỉ update trường không null hoặc có giá trị
@Getter
@Setter
public class UserEntity { // phai co private key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // tu dong tang gia tri va khong tao them bang
    private Long id; // userId

    @Column(columnDefinition = "varchar(255) comment 'user name'", nullable = false)
    private String userName;

    @Column(columnDefinition = "varchar(255) comment 'user email'", nullable = false, unique = true)
    private String userEmail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // feed mà không tham chiếu tới user nào sẽ tự động xóa
    @ToString.Exclude
    private List<FeedEntity> feeds = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
