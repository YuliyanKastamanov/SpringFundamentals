package com.example.coffeeshop.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

    private Long id;
    private String username;

    private String password;


    public CurrentUser() {
    }


    public String getPassword() {
        return password;
    }

    public CurrentUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getId() {
        return id;
    }

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }


}
