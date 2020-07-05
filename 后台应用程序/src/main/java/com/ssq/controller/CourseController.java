package com.ssq.controller;

import com.ssq.data.JText;
import com.ssq.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/Student/Course",method = RequestMethod.GET)//学生查询自己的课程
    public JText getCourseBySTNo(String stno){
        return courseService.findCBySTNo(stno);
    }

    @RequestMapping(value="/CourseMsg",method = RequestMethod.GET)//查询某课程的详情
    public JText getCourseByCourseId(int courseid){
        return courseService.findCbyCourseId(courseid);
    }

    @RequestMapping(value = "/Teacher/Course",method = RequestMethod.GET)//教师查询自己的课程
    public JText getCourseByTeacherId(String teacherid){return courseService.findCByTeacherId(teacherid);}
}
