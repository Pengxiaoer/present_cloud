package com.ssq.service;

import com.ssq.data.JText;

public interface SignRecordService {
    public JText signByCourseId(int courseid,String studentid);
    public JText getSignRecordByCourseid(int courseid,String studentid);
    public JText getSignRecordBySignId(int signid);
}
