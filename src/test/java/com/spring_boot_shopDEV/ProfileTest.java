package com.spring_boot_shopDEV;

import com.spring_boot_shopDEV.entity.user.Profile;
import com.spring_boot_shopDEV.entity.user.UserEntity;
import com.spring_boot_shopDEV.repository.ProfileRepository;
import com.spring_boot_shopDEV.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest // phải có springboot test thì mới inject được
public class ProfileTest {
    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(false)
    void oneToOneTest() {
        UserEntity user = new UserEntity();
        Profile profile = new Profile();

        user.setUserEmail("@gmail.com");
        user.setUserName("dinhpha/");
        profile.setBio("dinhpham04");
        user.setProfile(profile);
        userRepository.save(user);
    }

}
