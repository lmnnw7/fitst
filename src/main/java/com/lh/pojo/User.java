package com.lh.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;

    public User(String john, String password123) {
    }
}
