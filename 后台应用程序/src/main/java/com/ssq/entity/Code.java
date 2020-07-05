package com.ssq.entity;

import java.util.Date;

public class Code {
    private int CodeId;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    private Date time;
    public int getCodeId() {
        return CodeId;
    }

    public void setCodeId(int codeId) {
        CodeId = codeId;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    private int Code;
    private String tel;
}
