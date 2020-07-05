package com.ssq.dao;

import com.ssq.entity.SignRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface SignRecordMapper {
    public void signBySignId(int signrecordid, int signid, Date signtime,String studentid);
    public int findSignRecordId();
    public SignRecord getSignRecord(int signid,String studentid);
    public List<SignRecord> getSignRecordBySignId(int signid);
}
