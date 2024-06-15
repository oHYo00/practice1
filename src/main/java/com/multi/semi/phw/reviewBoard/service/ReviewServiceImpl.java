package com.multi.semi.phw.reviewBoard.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.board.model.dto.Board2DTO;
import com.multi.spring.reviewBoard.model.dao.ReviewDAO;
import com.multi.spring.reviewBoard.model.dto.Page2DTO;
import com.multi.spring.reviewBoard.model.dto.ReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDAO;
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	
	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return reviewDAO.selectCount(sqlSession);
	}

	@Override
	public List<ReviewDTO> reviewMain(Page2DTO pageDto) {
		// TODO Auto-generated method stub
		return reviewDAO.reviewMain(sqlSession, pageDto);
	}


	
	@Override
	public ReviewDTO selectTitle(Integer no) {
		// TODO Auto-generated method stub
		return reviewDAO.selectTitle(sqlSession, no);
	}
	

	
	
//	@Override
//	public void insertReview(ReviewDTO reviewDTO) throws Exception {
//		// TODO Auto-generated method stub
//		int result = reviewDAO.insertReview(sqlSession, reviewDTO);
//		
//		if(result < 0) {
//			throw new Exception("등록실패");
//		}
//		
//	}
	
	
	
	@Override
	public void reviewInsert(ReviewDTO reviewDTO) throws Exception {
		// TODO Auto-generated method stub
		int result = reviewDAO.reviewInsert(sqlSession, reviewDTO);
		if(result < 0) {
			throw new Exception("게시글 작성에 실패 하였습니다.");
		}
		
	}
	
	

	@Override
	public void reviewUpdate(ReviewDTO reviewDTO) throws Exception {
		// TODO Auto-generated method stub
		int result = reviewDAO.reviewUpdate(sqlSession, reviewDTO);
		if(result < 0) {
			throw new Exception("게시글 수정에 실패 하였습니다.");
		}
		
	}

	@Override
	public void reviewDelete(Integer no) throws Exception {
		// TODO Auto-generated method stub
		int result = reviewDAO.reviewDelete(sqlSession, no);
		if(result < 0) {
			throw new Exception("게시글 삭제에 실패 하였습니다.");
		}
		
	}

	

	
	
	
	
}
