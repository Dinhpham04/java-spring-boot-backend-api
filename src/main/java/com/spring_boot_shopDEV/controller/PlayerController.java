package com.spring_boot_shopDEV.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    @Value("${player.username}")
    private String PlayerName;
    @Value("${player.age}")
    private int PlayerAge;
    @Value("${player.address}")
    private String PlayerAddress;

    @GetMapping("/v1/api/player/1")
    public String getInfo() {
        return PlayerAge + " " + PlayerAddress + " " + PlayerName;
    }
}
