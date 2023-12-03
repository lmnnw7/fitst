package com.lh.service;

import com.lh.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();//查找所有用户
    User Log(User user);//用户登录
    User Register(User user);//用户注册
    User findUserByUsername(String username);//通过用户名查找用户
//    User getCurrentUser();
}
