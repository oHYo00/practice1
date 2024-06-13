package com.multi.spring.game.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.game.model.dto.GameDTO;
import com.multi.spring.page.model.dto.PageDTO;

@Repository
public class GameDAO {

	public ArrayList<GameDTO> gaemLank(SqlSessionTemplate my, PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return (ArrayList)my.selectList("game.selectlistGame",pageDTO);
	}

	public int selectCount(SqlSessionTemplate my) {
		// TODO Auto-generated method stub
		return my.selectOne("game.gameCount");
	}

	public int insertGame(SqlSessionTemplate my, GameDTO gameDTO) {
		// TODO Auto-generated method stub
		return my.insert("game.insert",gameDTO);
	}

	public GameDTO gaemSelectOne(SqlSessionTemplate my, GameDTO gameDTO) {
		// TODO Auto-generated method stub
		return my.selectOne("game.one",gameDTO);
	}

	public int gaemUpdate(SqlSessionTemplate my, GameDTO gameDTO) {
		// TODO Auto-generated method stub
		return my.update("game.update",gameDTO);
	}

	public int gaemDelete(SqlSessionTemplate my, GameDTO gameDTO) {
		// TODO Auto-generated method stub
		 return my.update("game.delete",gameDTO);
	}

}
