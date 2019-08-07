package com.liefeng.studio.stduio.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.Task;
import com.liefeng.studio.stduio.entity.User;
import com.liefeng.studio.stduio.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskMapper taskMapper;

    public PageInfo<Task> getAllTask(ServiceRequest serviceRequest) {
        int pageSize = Integer.parseInt((String) serviceRequest.getParam().get("page_size"));
        int pageNumber = Integer.parseInt((String) serviceRequest.getParam().get("page_number"));
        String search_key = (String) serviceRequest.getParam().get("search_key");

        PageHelper.startPage(pageNumber == 0 ? 1 : pageNumber, pageSize == 0 ? 20 : pageSize, true);
        List<Task> tasks = taskMapper.getAllTask(search_key);
        return new PageInfo<>(tasks);
    }
}
