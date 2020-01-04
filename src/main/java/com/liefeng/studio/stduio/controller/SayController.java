package com.liefeng.studio.stduio.controller;


import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.ServiceResponse;
import com.liefeng.studio.stduio.service.SayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/say")
public class SayController {

    @Autowired
   private SayService sayService;

    @PostMapping("/getallsay")
    public ServiceResponse getAllSay(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(sayService.getSay(serviceRequest));
    }

    @PostMapping("/writesay")
    public ServiceResponse writeSay(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(sayService.writeSay(serviceRequest));
    }

    @PostMapping("/getSayNumber")
    public ServiceResponse getSayNumber(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(sayService.getSayNumberSay(serviceRequest));
    }

    @PostMapping("/getSayDetail")
    public ServiceResponse getAllSayDetail(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(sayService.getSayDetail(serviceRequest));
    }



}
