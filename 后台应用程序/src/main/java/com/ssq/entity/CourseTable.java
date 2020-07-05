package com.ssq.entity;

public class CourseTable {
    private int CourseTableId;

    public int getCourseTableId() {
        return CourseTableId;
    }

    public void setCourseTableId(int courseTableId) {
        CourseTableId = courseTableId;
    }

    public int getCourseId() {
        return CourseId;
    }

    public void setCourseId(int courseId) {
        CourseId = courseId;
    }

    public int getClassId() {
        return ClassId;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }

    private int CourseId;
    private int ClassId;
}
