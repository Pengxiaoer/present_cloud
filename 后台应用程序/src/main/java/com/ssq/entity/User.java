package com.ssq.entity;

public class User {
    private int UserId;
    private String STNo;

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getSTNo() {
        return STNo;
    }

    public void setSTNo(String STNo) {
        this.STNo = STNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    private String Password;
    private String Tel;
}
