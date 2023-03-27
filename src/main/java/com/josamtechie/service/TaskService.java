package com.josamtechie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josamtechie.model.Task;
import com.josamtechie.repository.TaskRepository;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public Task addTask(Task task) {
	task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
	return repository.save(task);
	}

	public List<Task> findAllTask(){
		return repository.findAll();
	}

	public Task getTaskByTaskId(String taskId){
		return repository.findById(taskId).get();
	}

	public List<Task> getTaskBySeverity(int severity){
		return repository.findBySeverity(severity);
	}

	public List<Task> getTaskByAssignee(String assignee){
		return repository.getTaskByAssignee(assignee);
	}

	public Task updateTask(Task taskRequest){
		Task exisistingTask=repository.findById(taskRequest.getTaskId()).get();
		exisistingTask.setDescryption(taskRequest.getDescryption());
		exisistingTask.setSeverity(taskRequest.getSeverity());
		exisistingTask.setStoryPoint(taskRequest.getStoryPoint());
		exisistingTask.setAssignee(taskRequest.getAssignee());
		return repository.save(exisistingTask);
	}

	public String deleteTask(String taskId){
		repository.deleteById(taskId);
		return "Task "+taskId+" deleted successfully";
	}

}
