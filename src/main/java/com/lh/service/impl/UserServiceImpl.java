package com.lh.service.impl;

import com.lh.mapper.UserMapper;
import com.lh.pojo.User;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//服务类，优先使用
@Primary
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;


    @Override
    public List<User> findAllUsers() {
        return userMapper.findAllUsers();
    }

    @Override
    public User Log(User user) {
        return userMapper.Log(user);
    }

    @Override
    public int Register(User user) {
        return userMapper.Register(user);
    }

    @Override
    public User findUserByUsername(String username) {
        User u=userMapper.findUserByUsername(username);
        return u;
    }

    @Override
    public User findUserByID(Integer id) {
        return userMapper.findUserByID(id);
    }

    @Override
    public int deleteUserByID(Integer id) {
        return userMapper.deleteUserByID(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> findUserByStr(String searchStr) {
        return userMapper.findUserByStr(searchStr);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

}
