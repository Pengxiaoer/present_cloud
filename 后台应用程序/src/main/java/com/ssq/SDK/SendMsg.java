package com.ssq.SDK;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import exception.BaseException;
import exception.ExceptionCode;

import java.util.HashMap;
import java.util.Map;

public class SendMsg {
    static final String product = "Dysmsapi";
    static final String domain = "dysmsapi.aliyuncs.com";
    public int  sendmsg(String tel)throws ClientException{
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAIgFYBwXUZzWi1", "HeGWGRXtgz7XOzs96StFvZ6zdlfG74");
        DefaultProfile.addEndpoint("default", "default", product, domain);
        IAcsClient client = new DefaultAcsClient(profile);
        int randnum= (int) ((Math.random() * 9 + 1) * 100000) ;
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(tel);
        request.setSignName("上上签");
        request.setTemplateCode("SMS_168306603");
        request.setTemplateParam("{\"code\":\""+randnum+"\"}");
        SendSmsResponse sendSmsResponse=client.getAcsResponse(request);
        if(!sendSmsResponse.getCode().equals("OK")){
            throw new BaseException("手机号码非法", ExceptionCode.REQ_PARAM_ERR);
        }
        return randnum;
    }
}
