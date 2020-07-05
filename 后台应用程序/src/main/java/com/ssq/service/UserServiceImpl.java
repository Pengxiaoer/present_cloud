package com.ssq.service;

import com.ssq.dao.CodeMapper;
import com.ssq.dao.UserMapper;
import com.ssq.data.JText;
import com.ssq.entity.Code;
import com.ssq.entity.User;
import exception.BaseException;
import exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CodeMapper codeMapper;

    public List<User> findAllUser(){
        return userMapper.findAll();
    }

    public JText userLogin(String stno, String password){
        List<User> list = userMapper.findAll();
        JText jText=new JText();
        for(User u:list){
            if(u.getSTNo().equals(stno)){
                if(u.getPassword().equals(password)){
                    jText.setCode(200);
                    jText.setMsg("login success");
                    jText.setData(u);
                    return jText;
                }
                else{
                    throw new BaseException("密码错误", ExceptionCode.REQ_PARAM_ERR);
                }
            }
        }
        throw new BaseException("用户不存在", ExceptionCode.NOT_FOUND_ERR);
    }

    public JText updatePassword(String stno,String password,String oldpassword){
        JText jText=new JText();
        User u=new User();
        u=userMapper.findBySTNo(stno);
        if(u==null){
            throw new BaseException("用户不存在",ExceptionCode.NOT_FOUND_ERR);
        }
        else if(u.getPassword().equals(oldpassword)){
            userMapper.updatePassword(stno,password,oldpassword);
            jText.setCode(200);
            jText.setMsg("success");
            return jText;
        }
        else
            throw new BaseException("原密码不正确",ExceptionCode.REQ_PARAM_ERR);
    }

    public JText forgetPassword(String tel,String password,int code){
        JText jText=new JText();
        List<Code> s=codeMapper.find(tel);
        Code c=s.get(s.size()-1);
        if(c.getCode()!=code){
            throw new BaseException("验证码错误",ExceptionCode.REQ_PARAM_ERR);
        }
        Date date=new Date();
        Date date2=c.getTime();
        long signtime=date.getTime();
        long signtime2=date2.getTime();
        float d= (float) ((signtime-signtime2)/1000.0);
        if(d>300){
            throw new BaseException("操作超时", ExceptionCode.REQ_PARAM_ERR);
        }
        else{
            userMapper.forgetpassword(tel,password);
            jText.setCode(200);
            jText.setMsg("success");
            return jText;
        }
    }
}
