package com.multi.spring.board.service;



import java.util.List;

import com.multi.spring.board.model.dto.Board2DTO;

public interface Board2Service {

	void insertBoard(Board2DTO board2DTO) throws Exception;

	void deleteBoard(int no) throws Exception;

	void updateBoard(Board2DTO board2DTO) throws Exception;

	Board2DTO selectBoard(int no) throws Exception;

	List<Board2DTO> selectList() throws Exception;


}
