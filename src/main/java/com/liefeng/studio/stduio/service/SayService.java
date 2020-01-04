package com.liefeng.studio.stduio.service;

import com.liefeng.studio.stduio.entity.Say;
import com.liefeng.studio.stduio.entity.SaySayComment;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.User;
import com.liefeng.studio.stduio.mapper.SayMapper;
import com.liefeng.studio.stduio.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SayService {

    @Autowired
    private SayMapper sayMapper;
    private UserMapper userMapper;

    public Map<String, Object> getSay(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        List<Say> sayList = sayMapper.getSendSay();
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

    public Map<String, Object> getSayNumberSay(ServiceRequest serviceRequest){
        Map<String ,Object> result = new HashMap<>();
        int sayNumber = sayMapper.getSayNumberSay();
        result.put("msg",sayNumber);
        return result;
    }

    public Map<String, Object> getSayDetail(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        int sayNumber = sayMapper.getSayNumberSay();

        for (int i = 1; i < sayNumber+1; i++) {
            Say say = sayMapper.getSay(i);
            String say_title = say.getSay_title();
            String userName = say.getUser_name();
            Object img = userMapper.getIcon(userName);
            say.setUser_icon(new String((byte[]) img));
            List<SaySayComment> saySayComments = sayMapper.getSayComment(say_title);
            say.setComment(saySayComments);
            result.put("saydetail_"+i,say);
        }

        return result;
    }



}
