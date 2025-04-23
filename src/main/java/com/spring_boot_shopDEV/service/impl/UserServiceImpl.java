package com.spring_boot_shopDEV.service.impl;

import com.spring_boot_shopDEV.entity.user.UserEntity;
import com.spring_boot_shopDEV.repository.UserRepository;
import com.spring_boot_shopDEV.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
}
