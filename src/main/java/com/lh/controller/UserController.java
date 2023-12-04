package com.lh.controller;

import com.lh.pojo.User;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.async.DeferredResult;




@RequestMapping("/api")
@RestController
public class UserController {
    @Autowired(required = false)
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal User user) {
        if (user != null) {
            User user1 = userService.findUserByUsername(user.getUsername());
            return ResponseEntity.ok(user1);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


    //用户登录
    @RequestMapping("/login")
    public ResponseEntity<User> Log(@RequestBody User user){
        User u=userService.Log(user);
        if(u!=null){
            return ResponseEntity.ok(u);
        }
        else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    //用户注册
    @RequestMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findUserByUsername(user.getUsername())==null){
            System.out.println("1");
            int i=userService.Register(user);
            return ResponseEntity.ok("成功");
        } else {
            System.out.println("2");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    //用户登出
    @RequestMapping("/logout")
    public ResponseEntity<String> logout(SessionStatus sessionStatus) {
        System.out.println("111");
        DeferredResult<String> deferredResult = new DeferredResult<>();
        sessionStatus.setComplete();
        deferredResult.setResult("用户注销成功");

        return ResponseEntity.ok("888");
    }
}
