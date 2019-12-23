package com.liefeng.studio.stduio.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.User;
import com.liefeng.studio.stduio.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    /*
    登录
     */
    public Map<String, Object> login(ServiceRequest serviceRequest) {
        Map<String , Object> result = new HashMap<>();
        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));
        String userPassword = String.valueOf(serviceRequest.getParam().get("user_password"));
        System.out.println(userName);
        System.out.println(userPassword);
        User user = userMapper.checkUser(userName, userPassword);
        if (user == null){
            result.put("msg","用户名不存在！");
        }else{
            result.put("msg", user);
        }
        return result;

    }
    /*
    注册
     */
    public Map<String, Object> register(ServiceRequest serviceRequest){
        Map<String ,Object> result = new HashMap<>();
        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));
        String userPassword = String.valueOf(serviceRequest.getParam().get("user_password"));
        String userPhone = String.valueOf(serviceRequest.getParam().get("user_phone"));
        String userEmail = String.valueOf(serviceRequest.getParam().get("user_email"));
        String userAddress = String.valueOf(serviceRequest.getParam().get("user_address"));
        userMapper.registerUser(userName, userPhone, userPassword, userEmail, userAddress);
        result.put("msg","注册成功！");
        return result;
    }

    public PageInfo<User> getAllUser(ServiceRequest serviceRequest) {
        int pageSize = Integer.parseInt((String) serviceRequest.getParam().get("page_size"));
        int pageNumber = Integer.parseInt((String) serviceRequest.getParam().get("page_number"));
        String search_key = (String) serviceRequest.getParam().get("search_key");

        PageHelper.startPage(pageNumber == 0 ? 1 : pageNumber, pageSize == 0 ? 20 : pageSize, true);
        List<User> users = userMapper.getAllUser(search_key);
        return new PageInfo<>(users);
    }

    public Map<String, Object> getUserById(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String userId = String.valueOf(serviceRequest.getParam().get("user_id"));
        User getUser = userMapper.getUserById(userId);
        result.put("user",getUser);
        return result;
    }

}
