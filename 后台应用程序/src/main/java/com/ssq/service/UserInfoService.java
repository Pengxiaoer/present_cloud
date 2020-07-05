package com.ssq.service;

import com.ssq.data.JText;
import com.ssq.entity.UserInfo;

import java.util.List;

public interface UserInfoService {
    public JText getTeacherPage(int pageindex, int everypage);
    public JText getStudentPage(int pageindex,int everypage);
    public JText addUser(String stno,String password,String name,String tel,String academy,String major,int roleid);
    public JText deleteUser(String stno);
    public JText findUser(String stno,String name);
    public JText getSelfMsg(String stno);
}
