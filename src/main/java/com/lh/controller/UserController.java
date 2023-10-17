package com.lh.controller;

import com.lh.pojo.User;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("llhh")
public class UserController {
    @Autowired(required = false)
    private UserService userService;
    @RequestMapping("index")
    public String toindex(){
        return "sese/index";
    }
    //用户登录
    @RequestMapping("/log")
    public String Log(User user, Model model){
//        try{
//            User user2= userService.Log(user);
//            String name= user.getUsername();
//            System.out.println(name);
//            model.addAttribute("username",name);
//            return "sese/index";
//        }
//        catch(Exception e){
//            return "public/login_fall";
//        }
        User user3=userService.Log(user);
        int i=user3.getId();
        if(i>0){return "sese/index";}
        else return "public/login_false";
    }
}
