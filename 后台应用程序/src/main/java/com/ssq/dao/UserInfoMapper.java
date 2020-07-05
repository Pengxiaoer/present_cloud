package com.ssq.dao;

import com.ssq.entity.User;
import com.ssq.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {
    public List<UserInfo> getTeacherPage(int start,int end);
    public List<UserInfo> getStudentPage(int start,int end);
    public void addUserInfo(Map<String,Object> map);
    public void deleteUserInfo(String stno);
    public List<UserInfo> findAll();
    public List<UserInfo> findUserInfo(String stno,String name);
}
