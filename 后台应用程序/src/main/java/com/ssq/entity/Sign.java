package com.ssq.entity;

import java.util.Date;

public class Sign {
    private int SignId;
    private int CourseId;
    private String TeacherId;

    public int getSignId() {
        return SignId;
    }

    public void setSignId(int signId) {
        SignId = signId;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    public float getDuration() {
        return Duration;
    }

    public void setDuration(float duration) {
        Duration = duration;
    }

    public Date getSignInTime() {
        return SignInTime;
    }

    public void setSignInTime(Date signInTime) {
        SignInTime = signInTime;
    }

    private float Duration;
    private Date SignInTime;
}
