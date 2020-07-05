package com.ssq.entity;

import java.sql.Date;

public class Course {
    private int CourseId;
    private String CourseName;

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public Date getExamTime() {
        return ExamTime;
    }

    public void setExamTime(Date examTime) {
        ExamTime = examTime;
    }

    public String getTeacherId() {
        return TeacherId;
    }

    public void setTeacherId(String teacherId) {
        TeacherId = teacherId;
    }

    private Date ExamTime;
    private String TeacherId;

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    private String TeacherName;
}
