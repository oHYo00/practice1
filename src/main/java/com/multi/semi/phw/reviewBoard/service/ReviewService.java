package com.multi.semi.phw.reviewBoard.service;

import java.util.List;

import com.multi.spring.board.model.dto.Board2DTO;
import com.multi.spring.reviewBoard.model.dto.Page2DTO;
import com.multi.spring.reviewBoard.model.dto.ReviewDTO;


public interface ReviewService {

	int selectCount();

	List<ReviewDTO> reviewMain(Page2DTO pageDto);


	ReviewDTO selectTitle(Integer no);
	
	
//	void insertReview(ReviewDTO reviewDTO) throws Exception;

	void reviewUpdate(ReviewDTO reviewDTO) throws Exception;

	void reviewDelete(Integer no) throws Exception;

	void reviewInsert(ReviewDTO reviewDTO) throws Exception;

	

}
