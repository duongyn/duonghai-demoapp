package com.nashtech.duonghai.shoppingonline.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthController {

    @GetMapping("/loginSuccess")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hell OAuth2");
    }
}
