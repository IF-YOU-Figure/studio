package com.liefeng.studio.stduio.controller;


import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.ServiceResponse;

import com.liefeng.studio.stduio.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public @ResponseBody ServiceResponse login(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(userService.login(serviceRequest));
    }

    @PostMapping("/register")
    public ServiceResponse register(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(userService.register(serviceRequest));
    }

    @PostMapping("/modifyuser")
    public ServiceResponse modify(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(userService.modify(serviceRequest));
    }

}
