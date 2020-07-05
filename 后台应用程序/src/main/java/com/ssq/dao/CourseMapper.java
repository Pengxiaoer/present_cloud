package com.ssq.dao;

import com.ssq.entity.Course;
import com.ssq.entity.CourseTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {
    public List<CourseTable> findCTByClassId(int classid);
    public Course findCByCourseId(int courseid);
    public List<Course> findCByTeacherId(String teacherid);
}

