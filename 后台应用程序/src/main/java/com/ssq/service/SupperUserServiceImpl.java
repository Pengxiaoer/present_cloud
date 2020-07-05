package com.ssq.service;

import com.ssq.dao.SupperUserMapper;
import com.ssq.data.JText;
import com.ssq.entity.SupperUser;
import exception.BaseException;
import exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupperUserServiceImpl implements SupperUserService{
    @Autowired
    private SupperUserMapper supperUserMapper;
    public JText login(String username, String password){
        JText jText=new JText();
        SupperUser supperUser=supperUserMapper.findsupperuser(username);
        if(supperUser==null){
            throw new BaseException("用户名错误", ExceptionCode.REQ_PARAM_ERR);
        }
        if(!supperUser.getPassword().equals(password)){
            throw new BaseException("密码错误",ExceptionCode.REQ_PARAM_ERR);
        }
        else{
            jText.setMsg("success");
            jText.setCode(200);
            return jText;
        }
    }
}
