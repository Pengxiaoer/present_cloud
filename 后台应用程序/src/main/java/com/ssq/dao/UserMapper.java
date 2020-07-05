package com.ssq.dao;

import com.ssq.entity.User;
import org.apache.ibatis.annotations.Mapper;
import sun.security.util.Password;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    public List<User> findAll();
    public User  findBySTNo(String stno);
    public void addUser(Map<String,Object> map);
    public void deleteUser(String stno);
    public User findUser(String stno);
    public void updatePassword(String stno,String password,String oldpassword);
    public void register(int userid,String stno,String password,String tel);
    public void forgetpassword(String tel,String password);
    public User findallbytel(String tel);
}
