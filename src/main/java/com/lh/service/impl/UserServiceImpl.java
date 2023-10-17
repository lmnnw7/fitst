package com.lh.service.impl;

import com.lh.mapper.UserMapper;
import com.lh.pojo.User;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service//服务类，优先使用
@Primary
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Override
    public User Log(User user) {
        return userMapper.Log(user);
    }
}
