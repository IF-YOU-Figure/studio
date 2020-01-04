package com.liefeng.studio.stduio.controller;


import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.ServiceResponse;
import com.liefeng.studio.stduio.service.EnglishService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eng")
public class EnglishController {

    private final EnglishService englishService;

    public EnglishController(EnglishService englishService) {
        this.englishService = englishService;
    }

    @PostMapping("/getdata")
    public ServiceResponse getCurrent(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(englishService.getEnglish(serviceRequest));
    }

    @PostMapping("/weekranking")
    public ServiceResponse weekRanking(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(englishService.weekRanking(serviceRequest));
    }

    @PostMapping("/totalranking")
    public ServiceResponse totalRanking(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(englishService.totalRanking(serviceRequest));
    }

    @PostMapping("/getnumber")
    public ServiceResponse getNumber(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(englishService.getNumber(serviceRequest));
    }

    @PostMapping("/getrecord")
    public ServiceResponse getRecord(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(englishService.getRecord(serviceRequest));
    }
}
