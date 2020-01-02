package com.liefeng.studio.stduio.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liefeng.studio.stduio.entity.ServiceRequest;
import com.liefeng.studio.stduio.entity.Task;
import com.liefeng.studio.stduio.mapper.TaskMapper;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TaskService {

    private final TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public PageInfo<Task> getAllTask(ServiceRequest serviceRequest) {
        int pageSize = Integer.parseInt((String) serviceRequest.getParam().get("page_size"));
        int pageNumber = Integer.parseInt((String) serviceRequest.getParam().get("page_number"));
        String search_key = (String) serviceRequest.getParam().get("search_key");

        PageHelper.startPage(pageNumber == 0 ? 1 : pageNumber, pageSize == 0 ? 20 : pageSize, true);
        List<Task> tasks = taskMapper.getAllTask(search_key);
        return new PageInfo<>(tasks);
    }


    public Map<String, Object> getMyTask(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String user_name = String.valueOf(serviceRequest.getParam().get("user_name"));
        List<Task> tasks = taskMapper.getMyTaskMapper(user_name);
        result.put("myTask",tasks);
        return result;
    }

    public Map<String, Object> createTask(ServiceRequest serviceRequest){
        Map<String, Object> result = new HashMap<>();
        String task_owner = String.valueOf(serviceRequest.getParam().get("user_name"));
        String task_description = String.valueOf(serviceRequest.getParam().get("task_description"));
        String task_name = String.valueOf(serviceRequest.getParam().get("task_name"));
        String task_time = String.valueOf(serviceRequest.getParam().get("task_time"));
        taskMapper.createTask(task_name,task_owner,task_description,task_time);
        result.put("msg","创建成功");
        return result;
    }

    public Map<String, Object> getTaskNumber(ServiceRequest serviceRequest){
        Map<String ,Object> result = new HashMap<>();
        int taskNumber = taskMapper.getTaskNumber();
        result.put("msg",taskNumber);
        return result;
    }

    public Map<String, Object> getAllTaskList(ServiceRequest serviceRequest){
        Map<String ,Object> result = new HashMap<>();
        List<Task> tasks = taskMapper.getAllTaskList();
        result.put("msg",tasks);
        return result;
    }



}
