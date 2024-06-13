package com.multi.spring.bbs.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.bbs.model.dto.BbsDTO;
import com.multi.spring.page.model.dto.PageDTO;

@Repository
public class BbsDAO {

	public int insertBbs(SqlSessionTemplate sqlSession, BbsDTO bbsDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert("bbsMapper.insertBbs",bbsDTO);
	}

	public List<BbsDTO> selectAll(SqlSessionTemplate sqlSession, PageDTO pageDTO) {
		// TODO Auto-generated method stub
		return (List)sqlSession.selectList("selectlistBbs2",pageDTO);
	}

	public int selectCount(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("bbsMapper.selectCount");
	}

	public BbsDTO selectOne(SqlSessionTemplate sqlSession, BbsDTO bbsDTO) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectBbsOne",bbsDTO);
	}

}
