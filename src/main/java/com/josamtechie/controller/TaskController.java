package com.josamtechie.controller;

import com.josamtechie.model.Task;
import com.josamtechie.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task addTask(@RequestBody Task task){
        return service.addTask(task);
    }

    @GetMapping
    public List<Task> getAllTask(){
        return service.findAllTask();
    }

    @GetMapping("/{taskId}")
    public Task getByTaskId(@PathVariable String taskId){
        return service.getTaskByTaskId(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> getBySeverity(@PathVariable int severity){
        return service.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getByAssignee(@PathVariable String assignee){
        return service.getTaskByAssignee(assignee);
    }

    @PutMapping
    public Task modifyTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public String deleteTask(@PathVariable String taskId){
        return service.deleteTask(taskId);
    }
}
