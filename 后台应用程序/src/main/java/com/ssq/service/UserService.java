package com.ssq.service;

import com.ssq.data.JText;
import com.ssq.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAllUser();
    public JText userLogin(String stno,String password);
    public JText updatePassword(String stno,String password,String oldpassword);
    public JText forgetPassword(String tel,String password,int code);
}
