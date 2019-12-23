package com.liefeng.studio.stduio.controller;


import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.ServiceResponse;

import com.liefeng.studio.stduio.service.UserService;
import javafx.concurrent.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ServiceResponse login(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(userService.login(serviceRequest));
    }

    @PostMapping("/register")
    public ServiceResponse register(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(userService.register(serviceRequest));
    }

}
