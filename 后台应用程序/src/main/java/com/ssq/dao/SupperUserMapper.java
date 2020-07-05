package com.ssq.dao;

import com.ssq.entity.SupperUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupperUserMapper {
    public SupperUser findsupperuser(String supperusername);
}
