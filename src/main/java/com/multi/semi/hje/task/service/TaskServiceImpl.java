package com.multi.semi.hje.task.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.semi.hje.task.model.dao.TaskDAO;
import com.multi.semi.hje.task.model.dto.TaskDTO;
import com.multi.semi.hje.user.model.dto.UserDTO;

@EnableAspectJAutoProxy
@Service
public class TaskServiceImpl implements TaskService {
	private TaskDAO taskDAO = new TaskDAO();
	private SqlSessionTemplate sqlSession;

	@Autowired
	public TaskServiceImpl(TaskDAO taskDAO, SqlSessionTemplate sqlSession) {
		super();
		this.taskDAO = taskDAO;
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertTask(TaskDTO taskDTO) {
		int reult = taskDAO.insertTask(sqlSession, taskDTO);

		return reult;
	}

	@Override
	public ArrayList<TaskDTO> selectTaskList(UserDTO loginUser) throws Exception {

		ArrayList<TaskDTO> list = taskDAO.selectTaskList(sqlSession, loginUser);

		return list;

	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ArrayList<TaskDTO> updateTask(TaskDTO taskDTO, UserDTO loginUser) throws Exception {

		int result = taskDAO.updateTask(sqlSession, taskDTO);
		if (result <= 0) {
			throw new Exception("task 업데이트 실패!");
		}
		ArrayList<TaskDTO> list = taskDAO.selectTaskList(sqlSession, loginUser);
		return list;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ArrayList<TaskDTO> deleteTask(TaskDTO taskDTO, UserDTO loginUser) throws Exception {

		int result = taskDAO.deleteTask(sqlSession, taskDTO);
		if (result <= 0) {
			throw new Exception("task 업데이트 실패!");
		}
		ArrayList<TaskDTO> list = taskDAO.selectTaskList(sqlSession, loginUser);
		return list;
	}

}
