package com.lh.controller;

import com.lh.pojo.User;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    @Autowired(required = false)
    private UserDetailsService userDetailsService;

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {

        // 获取当前认证的用户信息
//        User user=userService.findUserByUsername(userDetails.getUsername());
        // 这里假设 UserDetails 对象代表了经过身份验证的用户信息
        // 你可以根据实际情况从数据库或其他存储中获取用户信息

        if (userDetails != null) {
            // 返回用户信息
            User user = userService.findUserByUsername(userDetails.getUsername());
            return ResponseEntity.ok(user);
        } else {
            // 未认证的情况下返回 401 未授权状态码
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    //用户登录
    @RequestMapping("/login")
    public ResponseEntity<User> Log( @RequestBody User user){
        User u=userService.Log(user);
        if(u!=null){
            return ResponseEntity.ok(u);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //用户注册
    @RequestMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userService.findUserByUsername(user.getUsername())==null){
            userService.Register(user);
            return ResponseEntity.ok("Registration successful");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already in use");
        }
    }

    //用户登出
    @RequestMapping("/logout")
    public ResponseEntity<String> logout(SessionStatus sessionStatus, Model model) {
        System.out.println("111");
        DeferredResult<String> deferredResult = new DeferredResult<>();
        sessionStatus.setComplete();
        deferredResult.setResult("用户注销成功");

        return ResponseEntity.ok("888");
    }
}
