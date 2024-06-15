package com.multi.spring.reviewBoard.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.board.model.dto.Board2DTO;
import com.multi.spring.reviewBoard.model.dto.Page2DTO;
import com.multi.spring.reviewBoard.model.dto.ReviewDTO;

@Repository
public class ReviewDAO {

	public int selectCount(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("reviewMapper.selectCount");
	}

	public List<ReviewDTO> reviewMain(SqlSessionTemplate sqlSession, Page2DTO pageDto) {
		// TODO Auto-generated method stub
		return (List)sqlSession.selectList("reviewMapper.reviewMain", pageDto);
	}

	
	public ReviewDTO selectTitle(SqlSessionTemplate sqlSession, Integer no) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("reviewMapper.selectTitle", no);
	}
	

	
//	public int insertReview(SqlSessionTemplate sqlSession, ReviewDTO reviewDTO) {
//		// TODO Auto-generated method stub
//		return sqlSession.insert("reviewMapper.insertReview", reviewDTO);
//	}
	
	
	
	public int reviewInsert(SqlSessionTemplate sqlSession, ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert("reviewMapper.reviewInsert", reviewDTO);
	}
	
	

	public int reviewUpdate(SqlSessionTemplate sqlSession, ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return sqlSession.update("reviewMapper.reviewUpdate", reviewDTO);
	}

	public int reviewDelete(SqlSessionTemplate sqlSession, Integer no) {
		// TODO Auto-generated method stub
		return sqlSession.delete("reviewMapper.reviewDelete", no);
	}

	

	

}
