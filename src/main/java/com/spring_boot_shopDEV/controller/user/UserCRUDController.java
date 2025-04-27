package com.spring_boot_shopDEV.controller.user;

import com.spring_boot_shopDEV.entity.user.UserEntity;
import com.spring_boot_shopDEV.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
// http://localhost:8080/user
public class UserCRUDController {
    @Autowired
    private UserService userService;

    // add User
    @PostMapping("/add")
    public UserEntity createUser(@RequestBody UserEntity userEntity) {
        return userService.createUser(userEntity);

    }

    @GetMapping("/search")
    public UserEntity getUserByNameAndEmail(@RequestParam String userName, @RequestParam String userEmail) {
        return userService.findByUserNameAnUserEmail(userName, userEmail);
    }

    @GetMapping("/test")
    public String testConnect() {
        return "Connected Successfully";
    }

    @GetMapping("/all")
    public Page<UserEntity> getAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.findAllUsers(pageable);
    }

    @GetMapping("/searchUser")
    public Page<UserEntity> searchUserByName(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);
        return userService.findByUserName(name, pageable);
    }
}
