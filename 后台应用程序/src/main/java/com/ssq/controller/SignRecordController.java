package com.ssq.controller;

import com.ssq.data.JText;
import com.ssq.service.SignRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignRecordController {
    @Autowired
    private SignRecordService signRecordService;

    @RequestMapping(value = "/Student/SignRecord",method = RequestMethod.PUT)//学生进行签到
    public JText signRecord(int courseid,String studentid){
        return signRecordService.signByCourseId(courseid,studentid);
    }

    @RequestMapping(value = "/Student/SignRecord",method = RequestMethod.GET)//学生查询自己某一课程的历史签到记录
    public JText getSignRecord(int courseid,String studentid){
        return signRecordService.getSignRecordByCourseid(courseid,studentid);
    }

    @RequestMapping(value = "/Teacher/SignRecord",method = RequestMethod.GET)//教师查询某次签到的签到情况
    public JText getSignRecordBySignId(int signid){
        return signRecordService.getSignRecordBySignId(signid);
    }
}
