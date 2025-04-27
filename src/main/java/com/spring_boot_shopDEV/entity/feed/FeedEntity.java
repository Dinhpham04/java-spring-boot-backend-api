package com.spring_boot_shopDEV.entity.feed;

import com.spring_boot_shopDEV.entity.user.UserEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "java_feed_001")
@DynamicInsert // chỉ insert trường không null
@DynamicUpdate
@Getter
@Setter
public class FeedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 255)
    private String title;
    @Lob // Large Object => Lưu trữ dữ liệu lớn
    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false) // chỉ định mỗi quan hệ này là bắt buộc
    // Khi xóa feed thì user cũng bị xóa, chỉ nên sử dụng Persist và merge
    @JoinColumn(name = "user_id", nullable = false) // foreign key
    private UserEntity user;
}
