package com.spring_boot_shopDEV.service;

import com.spring_boot_shopDEV.entity.user.UserEntity;

import java.util.List;

public interface UserService  {
    UserEntity createUser(UserEntity user);
    List<UserEntity> getAllUsers();
}
