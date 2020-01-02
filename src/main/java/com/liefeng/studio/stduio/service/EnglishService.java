package com.liefeng.studio.stduio.service;

import com.liefeng.studio.stduio.VO.EnglishVo;
import com.liefeng.studio.stduio.entity.English;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.mapper.EnglishMapper;
import com.liefeng.studio.stduio.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EnglishService {



    private final EnglishMapper englishMapper;


    public EnglishService(EnglishMapper englishMapper) {
        this.englishMapper = englishMapper;
    }

    public Map<String, Object> getEnglish(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));

        English currentEnglish = englishMapper.getCurrent(userName);

        English beforeEnglish = englishMapper.getBefore(userName);


        result.put("current",currentEnglish);
        result.put("before",beforeEnglish);

        return result;
    }

    public Map<String, Object> weekRanking(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String week = String.valueOf(serviceRequest.getParam().get("week"));
        List<EnglishVo> weekRanking = englishMapper.weekRanking(week);
        result.put("msg",weekRanking);
        return result;
    }

    public Map<String, Object> totalRanking(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        List<EnglishVo> totalRanking = englishMapper.totalRanking();
        result.put("msg",totalRanking);
        return result;
    }

}
