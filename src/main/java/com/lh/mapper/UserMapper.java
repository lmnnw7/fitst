package com.lh.mapper;

import com.lh.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> findAllUsers();//查找所有用户
    User Log(User user);//用户登录
    int Register(User user);//用户注册
    User findUserByUsername(String username);//通过用户名查找用户
    public User findUserByID(Integer id);
    int deleteUserByID(Integer id);
    int updateUser(User user);
    List<User> findUserByStr(String searchStr);
    int insertUser(User user);
}
