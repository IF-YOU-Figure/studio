package com.liefeng.studio.stduio.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liefeng.studio.stduio.entity.Book;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.Task;
import com.liefeng.studio.stduio.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {

    @Autowired
    private BookMapper bookMapper;

    public PageInfo<Book> getAllBook(ServiceRequest serviceRequest) {
        int pageSize = Integer.parseInt((String) serviceRequest.getParam().get("page_size"));
        int pageNumber = Integer.parseInt((String) serviceRequest.getParam().get("page_number"));
        String search_key = (String) serviceRequest.getParam().get("search_key");

        PageHelper.startPage(pageNumber == 0 ? 1 : pageNumber, pageSize == 0 ? 20 : pageSize, true);
        List<Book> books = bookMapper.getAllBook(search_key);
        return new PageInfo<>(books);
    }

    public List<Book> findBookByName(ServiceRequest serviceRequest) {
        String book_name = String.valueOf(serviceRequest.getParam().get("book_name"));
        return bookMapper.findBookByName(book_name);
    }

    public Map<String, Object> borrowBook(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String book_name = String.valueOf(serviceRequest.getParam().get("book_name"));
        String user_name = String.valueOf(serviceRequest.getParam().get("user_name"));
        String book_stock = bookMapper.getBookNumber(book_name);
        if (!book_stock.equals("0")){
            bookMapper.borrowBook(book_name,user_name);
            if (book_stock.equals("1")){
                bookMapper.updateBookOnlyOne("book_name");
            }else
                bookMapper.updateBookNotOnlyOne("book_name");
        }else{
            result.put("msg","该书不可借");
        }
        result.put("msg","借阅成功");
        return result;
    }

}
