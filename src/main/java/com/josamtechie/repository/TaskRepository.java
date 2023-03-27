package com.josamtechie.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.josamtechie.model.Task;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String>{

    List<Task> findBySeverity(int severity);

    @Query("{assignee: ?0 }")
    List<Task> getTaskByAssignee(String assignee);
}
