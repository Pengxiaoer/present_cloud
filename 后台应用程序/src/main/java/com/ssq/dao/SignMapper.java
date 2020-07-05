package com.ssq.dao;

import com.ssq.entity.Sign;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface SignMapper {
    public void signIn(int signid,int courseid, String teacherid, float duration, Date date);
    public int findMaxSignId();
    public int findMaxSignId2(int courseid);
    public Sign findSignBySignId(int signid);
    public List<Sign> getSignByCourseId(int courseid);
}
