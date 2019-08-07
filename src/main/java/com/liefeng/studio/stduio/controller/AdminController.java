package com.liefeng.studio.stduio.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.liefeng.studio.stduio.entity.*;
import com.liefeng.studio.stduio.service.BookService;
import com.liefeng.studio.stduio.service.TaskService;
import com.liefeng.studio.stduio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private BookService bookService;

    @PostMapping("/alluser")
    public ServiceResponse listUser(@RequestBody ServiceRequest serviceRequest){
        PageInfo<User> userPageInfo = userService.getAllUser(serviceRequest);
        return new ServiceResponse<>(userPageInfo);
    }

    @PostMapping("/alltask")
    public ServiceResponse listTask(@RequestBody ServiceRequest serviceRequest){
        PageInfo<Task> taskPageInfo = taskService.getAllTask(serviceRequest);
        return new ServiceResponse<>(taskPageInfo);
    }


    @PostMapping("/allbook")
    public ServiceResponse listBook(@RequestBody ServiceRequest serviceRequest){
        PageInfo<Book> bookPageInfo = bookService.getAllBook(serviceRequest);
        return new ServiceResponse<>(bookPageInfo);
    }



}
