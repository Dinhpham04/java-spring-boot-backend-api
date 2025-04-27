package com.spring_boot_shopDEV.repository;


import com.spring_boot_shopDEV.entity.feed.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<FeedEntity, Long> {

}
