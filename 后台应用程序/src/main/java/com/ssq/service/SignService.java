package com.ssq.service;

import com.ssq.data.JText;

import java.util.Date;

public interface SignService {
    public JText signIn(int courseid, String teacherid, float duration);
    public JText getSignByCourseId(int courseid);
}
