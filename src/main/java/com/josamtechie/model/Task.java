package com.josamtechie.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
	
	@Id
	private String taskId;
	private String descryption;
	private int severity;
	private String assignee;
	private int storyPoint;
}
