package com.ssq.controller;

import com.ssq.data.JText;
import com.ssq.entity.User;
import com.ssq.service.CodeService;
import com.ssq.service.UserService;
import exception.BaseException;
import exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CodeService codeService;

    @RequestMapping("/login")//统一用户登录
    public JText userLogin(String stno, String password){
        return userService.userLogin(stno,password);
    }

    @RequestMapping(value = "/User",method = RequestMethod.POST)//同意用户密码修改
    public  JText updatePassword(String stno,String password,String oldpassword){
        return userService.updatePassword(stno,password,oldpassword);
    }

    @RequestMapping("/register")
    public JText register(String stno,String tel,int code,String password){return codeService.check(stno,tel,code,password);}

    @RequestMapping("/forgetpassword")
    public JText forgetpassword(String tel,String password,int code){
        return userService.forgetPassword(tel,password,code);
    }
}
