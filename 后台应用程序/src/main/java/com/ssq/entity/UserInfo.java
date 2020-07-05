package com.ssq.entity;

public class UserInfo {
    private int UserInfoId;
    private int UserId;
    private int RoleId;

    public int getUserInfoId() {
        return UserInfoId;
    }

    public void setUserInfoId(int userInfoId) {
        UserInfoId = userInfoId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getRoleId() {
        return RoleId;
    }

    public void setRoleId(int roleId) {
        RoleId = roleId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSTNo() {
        return STNo;
    }

    public void setSTNo(String STNo) {
        this.STNo = STNo;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getAcademy() {
        return Academy;
    }

    public void setAcademy(String academy) {
        Academy = academy;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }

    private String Name;
    private String STNo;
    private String Major;
    private String Tel;
    private String Academy;
    private int ClassId;
}
