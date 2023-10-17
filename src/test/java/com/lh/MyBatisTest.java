package com.lh;

import com.lh.pojo.User;
import com.lh.service.UserService;
import com.lh.service.impl.UserServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    public static void main(String[] args) {


        // 加载 MyBatis 配置文件
//        String resource = "UserMapper.xml";
//        InputStream inputStream;
//        try {
//            inputStream = Resources.getResourceAsStream(resource);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return;
//        }
//
//        // 创建 SqlSessionFactory
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        // 创建 SqlSession
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            // 执行查询操作
//            User user = session.selectOne("com.lh.mapper.UserMapper.log",
//                    new User("john", "password123"));
//
//            if (user != null) {
//                System.out.println(user);
//            } else {
//                System.out.println("未找到匹配的用户.");
//            }
        }
    }

