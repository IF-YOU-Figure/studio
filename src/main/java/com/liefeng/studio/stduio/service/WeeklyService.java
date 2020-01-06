package com.liefeng.studio.stduio.service;


import com.liefeng.studio.stduio.VO.UserVO;
import com.liefeng.studio.stduio.VO.WeeklyVO;
import com.liefeng.studio.stduio.entity.Blog;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.Target_content;
import com.liefeng.studio.stduio.entity.Weekly;
import com.liefeng.studio.stduio.mapper.UserMapper;
import com.liefeng.studio.stduio.mapper.WeeklyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WeeklyService {

    @Autowired
    private WeeklyMapper weeklyMapper;
    @Autowired
    private UserMapper userMapper;


    public Map<String, Object> getDetail(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String date = String.valueOf(serviceRequest.getParam().get("date"));
        Weekly weekly = weeklyMapper.getDetail(date);
        result.put("msg",weekly);
        return result;
    }

    public Map<String, Object> createWeekly(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));
        String evaluate = String.valueOf(serviceRequest.getParam().get("evaluate"));
        String plan = String.valueOf(serviceRequest.getParam().get("plan"));
        String week = String.valueOf(serviceRequest.getParam().get("week"));
        weeklyMapper.createWeekly(userName,evaluate,plan,week);
        result.put("msg","提交成功");
        return result;
    }

    public Map<String, Object> createweeklyDetail(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));
        String target_content = String.valueOf(serviceRequest.getParam().get("target_content"));
        String situation = String.valueOf(serviceRequest.getParam().get("situation"));
        String week = String.valueOf(serviceRequest.getParam().get("week"));
        String date_task = String.valueOf(serviceRequest.getParam().get("date_task"));
        weeklyMapper.createWeeklyDetail(userName,target_content,situation,week,date_task);
        result.put("msg","成功");
        return result;
    }

    public Map<String, Object> getWeekly(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        List<WeeklyVO> weeklyVOS = weeklyMapper.getWeekly();
        result.put("msg",weeklyVOS);
        return result;
    }

    public Map<String, Object> getWeeklyDetail(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));
        String week = String.valueOf(serviceRequest.getParam().get("week"));
        List<Target_content> target_contents = weeklyMapper.getTargetContentPersonal(userName,week);
        Weekly weeklies = weeklyMapper.getWeeklyPersonal(userName,week);
        String user_direction = userMapper.getUserDirection(userName);
        result.put("weeklies",weeklies);
        result.put("target_contents",target_contents);
        result.put("inform",user_direction);
        return result;
    }

}
