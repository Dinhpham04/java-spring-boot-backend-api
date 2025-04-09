package com.spring_boot_shopDEV.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hehe {
    @GetMapping("/hihi")
    public String HeHe() {
        return "HeHe world";
    }
}
