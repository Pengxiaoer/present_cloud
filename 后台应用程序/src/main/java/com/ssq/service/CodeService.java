package com.ssq.service;

import com.ssq.data.JText;

public interface CodeService {
    public void sendcode(String tel);
    public JText check(String stno,String tel,int code,String password);
    public void sendcode2(String tel);
}
