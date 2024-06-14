package com.multi.semi.hje.task.model.dto;

import java.sql.Date;

public class TaskDTO {

	private String userId;
	private String taskId;
	private String content;
	private String complete;
	private Date createdDate;
	
	public TaskDTO() {
		
	}

	

	public Date getCreatedDate() {
		return createdDate;
	}



	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}



	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

	@Override
	public String toString() {
		return "TaskDTO [userId=" + userId + ", taskId=" + taskId + ", content=" + content
				+ ", complete=" + complete + "]";
	}
	
	
	
}
