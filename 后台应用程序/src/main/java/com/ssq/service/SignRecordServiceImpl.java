package com.ssq.service;

import com.ssq.dao.SignMapper;
import com.ssq.dao.SignRecordMapper;
import com.ssq.data.JText;
import com.ssq.entity.Sign;
import com.ssq.entity.SignRecord;
import exception.BaseException;
import exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SignRecordServiceImpl implements SignRecordService{
    @Autowired
    private SignRecordMapper signRecordMapper;
    @Autowired
    private SignMapper signMapper;

    public JText signByCourseId(int courseid, String studentid){
        JText jText=new JText();
        int signid=signMapper.findMaxSignId2(courseid);
        if(signid==0){
            throw new BaseException("不存在此签到", ExceptionCode.NOT_FOUND_ERR);
        }
        List<SignRecord> list=signRecordMapper.getSignRecordBySignId(signid);
        for(SignRecord s:list){
            if(s.getStudentId().equals(studentid)){
                throw new BaseException("请勿重复签到",ExceptionCode.REQ_PARAM_ERR);
            }
        }
        Sign sign=signMapper.findSignBySignId(signid);
        Date date=new Date();
        Date date2=sign.getSignInTime();
        long signtime=date.getTime();
        long signtime2=date2.getTime();
        float d= (float) ((signtime-signtime2)/1000.0);
        if(d>(sign.getDuration()*60)){
            throw new BaseException("签到超时", ExceptionCode.REQ_PARAM_ERR);
        }
        signRecordMapper.signBySignId(signRecordMapper.findSignRecordId()+1,signid,date,studentid);
        jText.setData(date);
        jText.setCode(200);
        jText.setMsg("success");
        return jText;
    }

    public JText getSignRecordByCourseid(int courseid,String studentid){
        JText jText=new JText();
        List<Sign> list=signMapper.getSignByCourseId(courseid);
        SignRecord signRecord=new SignRecord();
        List<SignRecord> list1=new ArrayList<>();
        for(Sign s:list){
            signRecord=signRecordMapper.getSignRecord(s.getSignId(),studentid);
            if(signRecord!=null){
                list1.add(signRecord);
            }
        }
        jText.setCode(200);
        jText.setMsg("success");
        jText.setData(list1);
        return jText;
    }

    public JText getSignRecordBySignId(int signid){
        JText jText=new JText();
        jText.setCode(200);
        jText.setMsg("success");
        jText.setData(signRecordMapper.getSignRecordBySignId(signid));
        return jText;
    }
}
