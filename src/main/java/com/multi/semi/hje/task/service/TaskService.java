package com.multi.semi.hje.task.service;

import java.util.ArrayList;

import com.multi.semi.hje.task.model.dto.TaskDTO;
import com.multi.semi.hje.user.model.dto.UserDTO;

public interface TaskService {

	public int insertTask(TaskDTO taskDTO) throws Exception;

	public ArrayList<TaskDTO> selectTaskList(UserDTO loginUser) throws Exception;

	public ArrayList<TaskDTO> updateTask(TaskDTO taskDTO, UserDTO loginUser) throws Exception;

	public ArrayList<TaskDTO> deleteTask(TaskDTO taskDTO, UserDTO loginUser) throws Exception;

}
