package com.multi.spring.board.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.board.model.dao.Board2DAO;
import com.multi.spring.board.model.dto.Board2DTO;
import com.multi.spring.page.model.dto.BoardDTO;


@Service
public class Board2ServiceImpl implements Board2Service {
	
	private final Board2DAO boardDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	public Board2ServiceImpl(Board2DAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public void insertBoard(Board2DTO board2DTO) throws Exception {
		// TODO Auto-generated method stub
		int result = boardDAO.insertBoard(sqlSession, board2DTO);
		if(result < 0) {
			throw new Exception("게시글 작성에 실패 하였습니다.");
		}
		
	}

	@Override
	public void deleteBoard(int no) throws Exception {
		// TODO Auto-generated method stub
		int result = boardDAO.deleteBoard(sqlSession, no);
		if(result < 0) {
			throw new Exception("게시글 삭제에 실패 하였습니다.");
		}
		
	}

	@Override
	public void updateBoard(Board2DTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		int result = boardDAO.updateBoard(sqlSession, boardDTO);
		if(result < 0) {
			throw new Exception("게시글 수정에 실패 하였습니다.");
		}
		
	}

	@Override
	public Board2DTO selectBoard(int no) throws Exception {
		// TODO Auto-generated method stub
		Board2DTO dto = boardDAO.selectBoard(sqlSession, no);
		return dto;
	}

	@Override
	public List<Board2DTO> selectList() throws Exception {
		// TODO Auto-generated method stub
		List<Board2DTO> list = boardDAO.selectList(sqlSession);
		return list;
	}
	

}
