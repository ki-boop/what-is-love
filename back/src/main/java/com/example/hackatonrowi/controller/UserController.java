package com.example.hackatonrowi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/")
    public Object user(@AuthenticationPrincipal Jwt jwt) {
        System.out.println(jwt);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        System.out.println(jwt.getId());
//        return Collections.singletonMap("name", principal.getAttribute("name"));
        return jwt;
    }

    @GetMapping("/echo")
    public String echo(@RequestBody String str) {
        return str;
    }
}
