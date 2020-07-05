package com.ssq.service;

import com.ssq.dao.CourseMapper;
import com.ssq.dao.UserInfoMapper;
import com.ssq.data.JText;
import com.ssq.entity.Course;
import com.ssq.entity.CourseTable;
import com.ssq.entity.UserInfo;
import exception.BaseException;
import exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    public JText findCBySTNo(String stno){
        JText jText=new JText();
        UserInfo u=new UserInfo();
        u=userInfoMapper.findUserInfo(stno,null).get(0);
        List<CourseTable> list=new ArrayList<>();
        list=courseMapper.findCTByClassId(u.getClassId());
        List<Course> list1=new ArrayList<>();
        for(CourseTable courseTable:list){
            list1.add(courseMapper.findCByCourseId(courseTable.getCourseId()));
        }
        jText.setCode(200);
        jText.setMsg("success");
        jText.setData(list1);
        return jText;
    }

    public JText findCbyCourseId(int courseid){
        JText jText=new JText();
        Course course = courseMapper.findCByCourseId(courseid);
        if(course==null){
            throw new BaseException("课程不存在", ExceptionCode.NOT_FOUND_ERR);
        }
        jText.setData(course);
        jText.setMsg("success");
        jText.setCode(200);
        return jText;
    }

    public JText findCByTeacherId(String teacherid){
        List<Course> list=courseMapper.findCByTeacherId(teacherid);
        JText jText=new JText();
        jText.setCode(200);
        jText.setMsg("success");
        jText.setData(list);
        return jText;
    }
}
