package com.liefeng.studio.stduio.service;


import com.liefeng.studio.stduio.entity.Blog;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.mapper.BlogMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BlogService {

    private BlogMapper blogMapper;

    public Map<String, Object> getBlogByName(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String blog_name = String.valueOf(serviceRequest.getParam().get("blog_name"));
        Blog blog = blogMapper.getBlogByName(blog_name);
        result.put("msg",blog);
        return result;
    }




}
