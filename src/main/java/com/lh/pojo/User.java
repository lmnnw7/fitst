package com.lh.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class User{
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;

    // 其他字段、构造函数等

}
