package com.liefeng.studio.stduio.controller;

import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.ServiceResponse;
import com.liefeng.studio.stduio.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Service;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/findbook")
    public ServiceResponse findBookByName(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(bookService.findBookByName(serviceRequest));
    }

    @PostMapping("/borrow")
    public ServiceResponse borrowBook(@RequestBody ServiceRequest serviceRequest){
        return new ServiceResponse<>(bookService.borrowBook(serviceRequest));
    }



}
