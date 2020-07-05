package com.ssq.controller;

import com.ssq.data.JText;
import com.ssq.entity.UserInfo;
import com.ssq.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/Teacher/Page",method = RequestMethod.GET)//获取教师用户信息页面，WEB端用
    public JText getTeacherPage(int indexpage,int everypage){
        return userInfoService.getTeacherPage(indexpage,everypage);
    }

    @RequestMapping(value = "/Student/Page",method = RequestMethod.GET)//获取学生用户信息页面，WEB端用
    public JText getStudentPage(int indexpage,int everypage){
        return userInfoService.getStudentPage(indexpage,everypage);
    }

    @RequestMapping(value = "/User",method = RequestMethod.PUT)//增加用户，WEB端用
    public JText addUser(String stno,String password,String name,String tel,String academy,String major,int roleid){
        return userInfoService.addUser(stno,password,name,tel,academy,major,roleid);
    }

    @RequestMapping(value="/User",method = RequestMethod.DELETE)//删除用户，WEB端用
    public JText deleteUser(String stno){
        return userInfoService.deleteUser(stno);
    }

    @RequestMapping(value="/User",method = RequestMethod.GET)//用户信息检索页面，WEB端用
    public JText findUser(@RequestParam(value = "stno",required = false) String stno,@RequestParam(value = "name",required = false) String name){
        return userInfoService.findUser(stno,name);
    }

    @RequestMapping(value = "/Self",method = RequestMethod.GET)//查看自己的信息，移动端用
    public JText getSelfMsg(String stno){
        return userInfoService.getSelfMsg(stno);
    }
}
