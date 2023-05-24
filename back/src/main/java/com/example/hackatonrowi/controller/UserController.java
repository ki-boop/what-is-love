package com.example.hackatonrowi.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UserController {

    @GetMapping("/")
    public Map<String, Object> user(@AuthenticationPrincipal Object jwt) {
//        System.out.println(jwt.getId());
//        return Collections.singletonMap("name", principal.getAttribute("name"));
        return null;
    }

    @GetMapping("/echo")
    public String echo(@RequestBody String str) {
        return str;
    }
}
