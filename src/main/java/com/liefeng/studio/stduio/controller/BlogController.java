package com.liefeng.studio.stduio.controller;


import com.liefeng.studio.stduio.entity.Blog;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.ServiceResponse;
import com.liefeng.studio.stduio.service.BlogService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/blog")
public class BlogController {

    private BlogService blogService;

    @PostMapping("/getBlog")
    public ServiceResponse getBlogByName(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(blogService.getBlogByName(serviceRequest));
    }




}
