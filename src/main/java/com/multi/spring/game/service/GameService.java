package com.multi.spring.game.service;

import java.util.ArrayList;

import com.multi.spring.game.model.dto.GameDTO;
import com.multi.spring.page.model.dto.PageDTO;

public interface GameService {

	ArrayList<GameDTO> gaemLank(PageDTO pageDTO)throws Exception;

	int selectCount()throws Exception;

	int insertGame(GameDTO gameDTO)throws Exception;

	GameDTO gaemSelectOne(GameDTO gameDTO)throws Exception;

	int gaemUpdate(GameDTO gameDTO)throws Exception;

	int gaemDelete(GameDTO gameDTO)throws Exception;

}
