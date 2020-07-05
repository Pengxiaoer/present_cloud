package com.ssq.service;

import com.ssq.data.JText;

import java.util.List;

public interface CourseService {
    public JText findCBySTNo(String stno);
    public JText findCbyCourseId(int courseid);
    public JText findCByTeacherId(String teacherid);
}
