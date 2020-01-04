package com.liefeng.studio.stduio.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liefeng.studio.stduio.VO.UserVO;
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

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 登录
     * @param serviceRequest
     * @return
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
        result.put("msg",getUser);
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

    public Map<String, Object> getOnlineNumber(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        int getOnlineNumber = userMapper.getOnlineNumber();
        result.put("msg",getOnlineNumber);
        return result;
    }

    public Map<String, Object> getUser(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));
        User user = userMapper.getUser(userName);
        UserVO userVO = new UserVO();
        userVO.setUser_name(user.getUser_name());
        userVO.setUser_email(user.getUser_email());
        userVO.setUser_address(user.getUser_address());
        userVO.setUser_phone(user.getUser_phone());
        userVO.setUser_qq(user.getUser_qq());
        userVO.setUser_age(user.getUser_age());
        userVO.setUser_position(user.getUser_position());
        userVO.setUser_grade(user.getUser_grade());
        userVO.setUser_direction(user.getUser_direction());
        userVO.setUser_target(user.getUser_target());
        result.put("msg",userVO);
        return result;
    }

    public Map<String, Object> getUserAll(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        List<UserVO> userAll = userMapper.getUserAll();
        result.put("msg",userAll);
        return result;
    }


    public Map<String, Object> modifyDetail(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();

        String userName = String.valueOf(serviceRequest.getParam().get("user_name"));
        String user_email = String.valueOf(serviceRequest.getParam().get("user_email"));
        String user_phone = String.valueOf(serviceRequest.getParam().get("user_phone"));
        String user_address = String.valueOf(serviceRequest.getParam().get("user_address"));
        String user_position = String.valueOf(serviceRequest.getParam().get("user_position"));
        String user_qq = String.valueOf(serviceRequest.getParam().get("user_qq"));
        String user_age = String.valueOf(serviceRequest.getParam().get("user_age"));
        String user_grade = String.valueOf(serviceRequest.getParam().get("user_grade"));
        String user_direction = String.valueOf(serviceRequest.getParam().get("user_direction"));
        String user_target = String.valueOf(serviceRequest.getParam().get("user_target"));
        userMapper.modifyDetail(userName,user_email,user_phone,user_address,user_position,
                user_qq,user_age,user_grade,user_direction,user_target);
        result.put("msg","修改成功");
        return result;
    }




}
