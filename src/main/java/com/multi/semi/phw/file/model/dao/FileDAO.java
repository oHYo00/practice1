package com.multi.semi.phw.file.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.movie.model.dto.MovieDTO;
import com.multi.spring.reviewBoard.model.dto.ReviewDTO;

@Repository
public class FileDAO {

	public int insertMovie(SqlSessionTemplate sqlSession, MovieDTO movieDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert("movieMapper.insertMovie", movieDTO);
	}

//	public int insertReview(SqlSessionTemplate sqlSession, ReviewDTO reviewDTO) {
//		// TODO Auto-generated method stub
//		return sqlSession.insert("reviewMapper.insertReview", reviewDTO);
//	}

}
