package com.multi.spring.game.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.spring.game.model.dao.GameDAO;
import com.multi.spring.game.model.dto.GameDTO;
import com.multi.spring.page.model.dto.PageDTO;

@Service
@EnableAspectJAutoProxy
@Transactional(rollbackFor = {Exception.class})
public class GameServiceImpl implements GameService{

	@Autowired
	GameDAO dao;

	@Autowired
	SqlSessionTemplate my;
	
	@Override
	public ArrayList<GameDTO> gaemLank(PageDTO pageDTO) throws Exception {

		 ArrayList<GameDTO>list=dao.gaemLank(my,pageDTO);
		
		return list;
	}

	@Override
	public int selectCount() throws Exception {
		int count=dao.selectCount(my);
		return count;
	}

	@Override
	public int insertGame(GameDTO gameDTO) throws Exception {


		int result=dao.insertGame(my,gameDTO);
		
		return result;
	}

	@Override
	public GameDTO gaemSelectOne(GameDTO gameDTO) throws Exception {
		GameDTO dto=dao.gaemSelectOne(my,gameDTO);
		return dto;
	}

	@Override
	public int gaemUpdate(GameDTO gameDTO) throws Exception {
		
		int result=dao.gaemUpdate(my,gameDTO);
		return result;
	}

	@Override
	public int gaemDelete(GameDTO gameDTO) throws Exception {
		int result=dao.gaemDelete(my,gameDTO);
		return result;
	}

}
