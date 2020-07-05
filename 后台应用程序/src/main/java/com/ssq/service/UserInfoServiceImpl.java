package com.ssq.service;

import com.ssq.dao.UserInfoMapper;
import com.ssq.dao.UserMapper;
import com.ssq.data.JText;
import com.ssq.entity.User;
import com.ssq.entity.UserInfo;
import exception.BaseException;
import exception.ExceptionCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private UserMapper userMapper;
    private JText jText;

    public JText getTeacherPage(int pageindex, int everypage){
        if(pageindex<=0||everypage<=0){
            throw new BaseException("输入的参数不可小于0", ExceptionCode.REQ_PARAM_ERR);
        }
        jText=new JText();
        jText.setData(userInfoMapper.getTeacherPage((pageindex-1)*everypage,everypage));
        jText.setCode(200);
        jText.setMsg("success");
        return jText;


    }

    public JText getStudentPage(int pageindex,int everypage){
        if(pageindex<=0||everypage<=0){
            throw new BaseException("输入的参数不可小于0", ExceptionCode.REQ_PARAM_ERR);
        }
        jText=new JText();
        jText.setData(userInfoMapper.getStudentPage((pageindex-1)*everypage,everypage));
        jText.setCode(200);
        jText.setMsg("success!");
        return jText;
    }

    public JText addUser(String stno, String password, String name, String tel, String academy, String major, int roleid){
        if(userMapper.findBySTNo(stno)!=null)
            throw new BaseException("用户已存在",ExceptionCode.REQ_PARAM_ERR);
        jText=new JText();
        List<User> list=userMapper.findAll();
        User u=list.get(list.size()-1);
        int userid=u.getUserId()+1;
        Map<String,Object> map=new HashMap<>();
        map.put("userid",userid);
        map.put("stno",stno);
        map.put("password",password);
        map.put("name",name);
        map.put("tel",tel);
        map.put("academy",academy);
        map.put("major",major);
        map.put("roleid",roleid);
        userMapper.addUser(map);
        userInfoMapper.addUserInfo(map);
        jText.setMsg("add success");
        jText.setCode(200);
        return jText;
    }

    public JText deleteUser(String stno){
        jText=new JText();
        if(userMapper.findBySTNo(stno)==null)
            throw new BaseException("用户不存在",ExceptionCode.NOT_FOUND_ERR);
        else{
            userMapper.deleteUser(stno);
            userInfoMapper.deleteUserInfo(stno);
            jText.setMsg("add success");
            jText.setCode(200);
            return jText;
        }

    }

    public JText findUser(String stno,String name){
        JText jText=new JText();
        List<UserInfo> userInfos=userInfoMapper.findUserInfo(stno,name);
        if(userInfos.size()==0){
            throw new BaseException("用户不存在",ExceptionCode.NOT_FOUND_ERR);
        }
        else{
            List<User> list=new ArrayList<>();
            for(UserInfo userInfo:userInfos){
                list.add(userMapper.findBySTNo(userInfo.getSTNo()));
            }
            Map<String,Object> map=new HashMap<>();
            map.put("user",list);
            map.put("userinfo",userInfos);
            jText.setCode(200);
            jText.setMsg("success");
            jText.setData(map);
            return jText;
        }
    }

    public JText getSelfMsg(String stno){
        JText jText=new JText();
        UserInfo userInfo=new UserInfo();
        List<UserInfo> list=userInfoMapper.findUserInfo(stno,null);
        if(list.size()==0){
            throw new BaseException("用户不存在",ExceptionCode.NOT_FOUND_ERR);
        }
        userInfo=list.get(0);
        jText.setCode(200);
        jText.setData(userInfo);
        jText.setMsg("success");
        return jText;
    }
}
