package com.ssq.controller;

import com.ssq.data.JText;
import com.ssq.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeController {
    @Autowired
    private CodeService codeService;

    @RequestMapping("/Code")
    public void sendCode(String tel){
         codeService.sendcode(tel);
    }

    @RequestMapping("/Code2")
    public void sendCode2(String tel){
        codeService.sendcode2(tel);
    }
}
