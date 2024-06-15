package com.multi.semi.phw.page.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.page.model.dto.BoardDTO;
import com.multi.spring.page.model.dto.PageDTO;

@Repository
public class BoardDAO {

	public List<BoardDTO> selectAll(SqlSessionTemplate sqlSession, PageDTO pageDto) {
		// TODO Auto-generated method stub
		return (List)sqlSession.selectList("boardMapper.selectAll", pageDto);
	}

	public int selectCount(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("boardMapper.selectCount");
	}

}
