package com.ssq.dao;

import com.ssq.entity.Code;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface CodeMapper {
    public void verification(int codeid, int code, String tel, Date time);
    public int findmaxid();
    public List<Code> find(String tel);
}
