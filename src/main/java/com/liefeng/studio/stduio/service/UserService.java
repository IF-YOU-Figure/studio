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
        String userEmail = String.valueOf(serviceRequest.getParam().get("user_email"));
        String userPassword = String.valueOf(serviceRequest.getParam().get("user_password"));
        User user = userMapper.checkUser(userEmail);
        if (user!=null){
            String password = user.getUser_password();
            if (password.equals(userPassword)){
                result.put("msg", user);
            }else {
                result.put("msg", "密码错误");
            }
        }else {
            result.put("msg","用户名不存在！");
        }
        System.out.println(result);
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
        result.put("msg","注册成功!");
        return result;
    }

    public Map<String, Object> updateIcon(ServiceRequest serviceRequest){
        Map<String ,Object> result = new HashMap<>();
        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));
        String userIcon = String.valueOf(serviceRequest.getParam().get("user_icon"));
        userMapper.updateIcon(userName,userIcon);
        result.put("msg","修改成功");
        return result;
    }

    public Map<String, Object> getIcon(ServiceRequest serviceRequest){
        Map<String ,Object> result = new HashMap<>();
        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));
        Object img = userMapper.getIcon(userName);
        result.put("msg", new String((byte[]) img));
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
    public Map<String,Object> modify(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));
        String newUserName = String.valueOf(serviceRequest.getParam().get("new_user_name"));
        String newUserEmail = String.valueOf(serviceRequest.getParam().get("new_user_email"));
        String newUserPassword = String.valueOf(serviceRequest.getParam().get("new_user_password"));
        userMapper.modifyUser(newUserName,userName,newUserEmail,newUserPassword);
        result.put("msg",newUserName);
        return result;
    }

}
