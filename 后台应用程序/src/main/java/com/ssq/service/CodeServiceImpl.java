package com.ssq.service;

import com.aliyuncs.exceptions.ClientException;
import com.ssq.SDK.SendMsg;
import com.ssq.dao.CodeMapper;
import com.ssq.dao.UserMapper;
import com.ssq.data.JText;
import com.ssq.entity.Code;
import com.ssq.entity.User;
import exception.BaseException;
import exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CodeServiceImpl implements CodeService{
    @Autowired
    private CodeMapper codeMapper;
    @Autowired
    private UserMapper userMapper;
    private SendMsg sendMsg;
    public void sendcode(String tel) {
        JText jText=new JText();
        sendMsg = new SendMsg();
        try{
            int code=sendMsg.sendmsg(tel);
            Date date=new Date();
            codeMapper.verification(codeMapper.findmaxid()+1,code,tel,date);
        }
        catch (ClientException e){
            e.printStackTrace();
        }

    }

    public JText check(String stno,String tel,int code,String password){
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
            List<User> s1=userMapper.findAll();
            for(User user:s1){
                if(user.getTel().equals(tel)){
                    throw new BaseException("该手机号已注册",ExceptionCode.REQ_PARAM_ERR);
                }
                if(user.getSTNo().equals(stno)){
                    throw new BaseException("该学号已注册",ExceptionCode.REQ_PARAM_ERR);
                }
            }
            User user=s1.get(s1.size()-1);
            userMapper.register(user.getUserId()+1,stno,password,tel);
            jText.setMsg("success");
            jText.setCode(200);
            return jText;
        }

    }

    public void sendcode2(String tel){
        User user=userMapper.findallbytel(tel);
        if(user==null){
            throw new BaseException("不存在该用户",ExceptionCode.NOT_FOUND_ERR);
        }
        sendMsg = new SendMsg();
        try{
            int code=sendMsg.sendmsg(tel);
            Date date=new Date();
            codeMapper.verification(codeMapper.findmaxid()+1,code,tel,date);
        }
        catch (ClientException e){
            e.printStackTrace();
        }
    }
}
