package com.lh.mapper;

import com.lh.pojo.User;

public interface UserMapper {
    User Log(User user);//用户登录
    User Sign(User user);//用户注册
}
