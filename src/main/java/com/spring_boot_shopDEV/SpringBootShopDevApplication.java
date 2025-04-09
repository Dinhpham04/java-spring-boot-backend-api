package com.spring_boot_shopDEV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootShopDevApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootShopDevApplication.class, args);
	}
	@GetMapping("/hello")
	public String Hello() {
		return "hello world";
	}
}
