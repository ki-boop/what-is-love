package com.example.hackatonrowi.controller;

import com.example.hackatonrowi.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public Object user(@AuthenticationPrincipal Jwt jwt) {
        return userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    @GetMapping("/echo")
    public String echo(@RequestBody String str) {
        return str;
    }
}
