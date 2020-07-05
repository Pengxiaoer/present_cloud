package com.ssq.service;

import com.ssq.dao.SignMapper;
import com.ssq.data.JText;
import com.ssq.entity.Sign;
import exception.BaseException;
import exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SignServiceImpl implements SignService{
    @Autowired
    private SignMapper signMapper;
    public JText signIn(int courseid, String teacherid, float duration){
        if(duration<=0){
            throw new BaseException("时间不能为负", ExceptionCode.REQ_PARAM_ERR);
        }
        Date date=new Date();
        signMapper.signIn(signMapper.findMaxSignId()+1,courseid,teacherid,duration,date);
        JText jText=new JText();
        jText.setMsg("success");
        jText.setCode(200);
        return jText;
    }

    public JText getSignByCourseId(int courseid){
        JText jText=new JText();
        List<Sign> list=signMapper.getSignByCourseId(courseid);
        jText.setData(list);
        jText.setMsg("success");
        jText.setCode(200);
        return jText;
    }
}
