package com.ssq.entity;

import java.util.Date;

public class SignRecord {
    private int SignRecordId;
    private int SignId;

    public int getSignRecordId() {
        return SignRecordId;
    }

    public void setSignRecordId(int signRecordId) {
        SignRecordId = signRecordId;
    }

    public int getSignId() {
        return SignId;
    }

    public void setSignId(int signId) {
        SignId = signId;
    }

    public Date getSignTime() {
        return SignTime;
    }

    public void setSignTime(Date signTime) {
        SignTime = signTime;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    private Date SignTime;
    private String StudentId;
}
