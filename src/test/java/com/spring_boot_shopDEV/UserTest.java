package com.spring_boot_shopDEV;

import com.spring_boot_shopDEV.entity.feed.FeedEntity;
import com.spring_boot_shopDEV.entity.user.Profile;
import com.spring_boot_shopDEV.entity.user.UserEntity;
import com.spring_boot_shopDEV.repository.FeedRepository;
import com.spring_boot_shopDEV.repository.ProfileRepository;
import com.spring_boot_shopDEV.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FeedRepository feedRepository;
    @Autowired
    private ProfileRepository profileRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToManyTest() {
        // 1. new User
        UserEntity user = new UserEntity();
        FeedEntity feed = new FeedEntity();

        user.setUserEmail("phamducdinh2505@gmail.com");
        user.setUserName("Pham Duc Dinh");
        user.setFeeds(List.of(feed));
        feed.setTitle("demo 001");
        feed.setDescription("description 001");
        feed.setUser(user);

        userRepository.save(user);
    }

    @Test
    @Transactional
    void selectOneToManyTest() {
        UserEntity user = userRepository.findById(3L).orElseThrow();
        System.out.println(user);
        System.out.println(user.getFeeds());
    }
}
