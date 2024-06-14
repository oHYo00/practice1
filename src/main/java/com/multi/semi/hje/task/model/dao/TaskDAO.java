package com.multi.semi.hje.task.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.semi.hje.task.model.dto.TaskDTO;
import com.multi.semi.hje.user.model.dto.UserDTO;


@Repository
public class TaskDAO {

	public ArrayList<TaskDTO> selectTaskList(SqlSession sqlSession, UserDTO loginUser) throws Exception {

		return (ArrayList) sqlSession.selectList("taskMapper.selectTaskList", loginUser);
	}

	public int insertTask(SqlSessionTemplate sqlSession, TaskDTO taskDTO) {
		
		return sqlSession.insert("taskMapper.insertTask", taskDTO);
	}

	public int updateTask(SqlSessionTemplate sqlSession, TaskDTO taskDTO) {
	
		return sqlSession.update("taskMapper.updateTask", taskDTO);
	}

	public int deleteTask(SqlSessionTemplate sqlSession, TaskDTO taskDTO) {
		return sqlSession.delete("taskMapper.deleteTask", taskDTO);
	}

}
