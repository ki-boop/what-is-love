package com.example.hackatonrowi.config;

import java.security.Principal;

public class MyPrincipal implements Principal {
    private String name;
    @Override
    public String getName() {
        return name;
    }
}
