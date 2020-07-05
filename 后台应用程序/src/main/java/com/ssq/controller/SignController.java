package com.ssq.controller;

import com.ssq.data.JText;
import com.ssq.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignController {
    @Autowired
    private SignService signService;

    @RequestMapping(value = "/Teacher/SignIn",method = RequestMethod.POST)//教师发布签到
    public JText signIn(int courseid,String teacherid,float duration){
        return signService.signIn(courseid,teacherid,duration);
    }

    @RequestMapping(value = "/Teacher/SignIn",method = RequestMethod.GET)//教师查看某一课程发布的签到
    public JText getSignInByCourseId(int courseid){
        return signService.getSignByCourseId(courseid);
    }
}
