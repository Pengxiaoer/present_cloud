package com.ssq.controller;

import com.ssq.data.JText;
import com.ssq.service.SupperUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupperUserController {
    @Autowired
    private SupperUserService supperUserService;

    @RequestMapping("/supperlogin")
    private JText supperlogin(String username,String password){
        return supperUserService.login(username,password);
    }
}
