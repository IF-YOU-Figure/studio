package com.liefeng.studio.stduio.service;

import com.liefeng.studio.stduio.entity.Say;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.mapper.SayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SayService {

    @Autowired
    private SayMapper sayMapper;

    public Map<String, Object> getSay(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();

        List<Say> sayList = sayMapper.getSendSay();
        System.out.println(sayList);
        result.put("msg",sayList);
        return result;
    }

    public Map<String, Object> writeSay(ServiceRequest serviceRequest){

        Map<String ,Object> result = new HashMap<>();
        String user_name = String.valueOf(serviceRequest.getParam().get("user_name"));
        String say_title = String.valueOf(serviceRequest.getParam().get("say_title"));
        String say_content = String.valueOf(serviceRequest.getParam().get("say_content"));
        sayMapper.writeSay(user_name,say_title,say_content);
        result.put("msg","发布成功！");
        return result;
    }


}
