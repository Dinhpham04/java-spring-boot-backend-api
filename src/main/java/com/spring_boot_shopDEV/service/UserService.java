package com.spring_boot_shopDEV.service;

import com.spring_boot_shopDEV.entity.user.UserEntity;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService  {
    UserEntity createUser(UserEntity userEntity);
    List<UserEntity> getAllUsers();
    UserEntity findByUserNameAnUserEmail(String userName, String userEmail);

    // get all by limit offset
    Page<UserEntity> findAllUsers(Pageable pageable);

    // get search
    Page<UserEntity> findByUserName(String userName, Pageable pageable);

}
