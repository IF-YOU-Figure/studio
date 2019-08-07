package com.liefeng.studio.stduio.controller;

import com.github.pagehelper.PageInfo;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.ServiceResponse;
import com.liefeng.studio.stduio.entity.User;
import com.liefeng.studio.stduio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/alluser")
    public ServiceResponse listUser(@RequestBody ServiceRequest serviceRequest){
        PageInfo<User> userPageInfo = userService.getAllUser(serviceRequest);
        return new ServiceResponse<>(userPageInfo);
    }

}
