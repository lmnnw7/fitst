package com.lh.controller;

import com.lh.pojo.User;
import com.lh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("llhh")
public class UserController {
    @Autowired(required = false)
    private UserService userService;
    @RequestMapping("index")
    public String toindex(){
        return "pages/index";
    }
    @RequestMapping("login")
    public String tolog(){
        return "pages/login";
    }
    @RequestMapping("signup")
    public String tosign(){
        return "pages/signup";
    }
    //用户登录
    @RequestMapping("/log")
    public String Log(User user, Model model){
        try{
            User u= userService.Log(user);
//            String name= u.getUsername();
//            System.out.println(name);
//            model.addAttribute("username",name);
            return "pages/index";
        }
        catch(Exception e){
            return "public/login_fall";
        }
//        User u=userService.Log(user);
//        if(u!=null){return "sese/index";}
//        else return "public/login_false";
    }
    @RequestMapping("/sign")
    public String Sign(User user){
        try{
            User u= userService.Sign(user);
//            String name= u.getUsername();
//            System.out.println(name);
//            model.addAttribute("username",name);
            return "pages/login";
        }
        catch(Exception e){
            return "public/login_fall";
        }
    }
}
