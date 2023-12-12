package com.lh.mapper;

import com.lh.pojo.User;

import java.util.List;

public interface UserMapper {
    User Log(User user);//用户登录
    int Register(User user);//用户注册
    User findUserByUsername(String username);//通过用户名查找用户
    List<User> findAllUsers();//查找所有用户
    User findUserByID(Integer id);//通过ID查找用户
    int deleteUserByID(Integer id);//通过ID删除用户
    int updateUser(User user);//编辑用户
    List<User> findUserByStr(String searchStr);//模糊查询用户
    int insertUser(User user);//添加用户
}
