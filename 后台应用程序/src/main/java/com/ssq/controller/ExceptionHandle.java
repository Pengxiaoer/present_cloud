package com.ssq.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import exception.BaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;

@RestControllerAdvice
public class ExceptionHandle {
    @Resource
    private ObjectMapper objectMapper;

    @ExceptionHandler(BaseException.class)
    public ObjectNode baseException(BaseException e){
        int code=e.getCode();
        String msg=e.getmsg();
        return objectMapper.createObjectNode().put("code",code).put("msg",msg);
    }
}
