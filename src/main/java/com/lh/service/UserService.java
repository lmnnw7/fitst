package com.lh.service;

import com.lh.pojo.User;

public interface UserService {
    User Log(User user);//用户登录
    User Sign(User user);//用户注册
}
