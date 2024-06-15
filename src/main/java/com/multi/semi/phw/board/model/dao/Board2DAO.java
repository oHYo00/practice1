package com.multi.semi.phw.board.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.board.model.dto.Board2DTO;


@Repository
public class Board2DAO {

	public int insertBoard(SqlSessionTemplate sqlSession, Board2DTO board2DTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert("board2Mapper.insertBoard", board2DTO);
	}

	public int deleteBoard(SqlSessionTemplate sqlSession, int no) {
		// TODO Auto-generated method stub
		return sqlSession.delete("board2Mapper.deleteBoard", no);
	}

	public int updateBoard(SqlSessionTemplate sqlSession, Board2DTO board2DTO) {
		// TODO Auto-generated method stub
		return sqlSession.update("board2Mapper.updateBoard", board2DTO);
	}

	public Board2DTO selectBoard(SqlSessionTemplate sqlSession, int no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("board2Mapper.selectBoard", no);
	}

	public List<Board2DTO> selectList(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (List)sqlSession.selectList("board2Mapper.selectList");
	}

	

}









