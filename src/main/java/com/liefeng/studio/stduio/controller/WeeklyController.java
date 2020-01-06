package com.liefeng.studio.stduio.controller;


import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.ServiceResponse;
import com.liefeng.studio.stduio.service.WeeklyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weekly")
public class WeeklyController {

    @Autowired
    private WeeklyService weeklyService;

    @PostMapping("/getDetail")
    public ServiceResponse getDetail(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(weeklyService.getDetail(serviceRequest));
    }

    @PostMapping("/createweekly")
    public ServiceResponse createWeekly(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(weeklyService.createWeekly(serviceRequest));
    }

    @PostMapping("/createweeklyDetail")
    public ServiceResponse createweeklyDetail(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(weeklyService.createweeklyDetail(serviceRequest));
    }

    @PostMapping("/getweekly")
    public ServiceResponse getWeekly(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(weeklyService.getWeekly(serviceRequest));
    }

    @PostMapping("/getweeklydetail")
    public ServiceResponse getWeeklyDetail(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(weeklyService.getWeeklyDetail(serviceRequest));
    }

}
