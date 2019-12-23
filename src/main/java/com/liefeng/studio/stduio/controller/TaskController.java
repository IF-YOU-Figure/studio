package com.liefeng.studio.stduio.controller;


import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.ServiceResponse;
import com.liefeng.studio.stduio.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    @PostMapping("/mytask")
    public ServiceResponse getMyTask(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(taskService.getMyTask(serviceRequest));
    }

    @PostMapping("/create")
    public ServiceResponse createTask(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(taskService.createTask(serviceRequest));
    }
}
