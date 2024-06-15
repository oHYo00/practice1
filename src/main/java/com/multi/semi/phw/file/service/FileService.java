package com.multi.semi.phw.file.service;

import com.multi.spring.movie.model.dto.MovieDTO;
import com.multi.spring.reviewBoard.model.dto.ReviewDTO;

public interface FileService {

	void insertMovie(MovieDTO movieDTO) throws Exception;
	
//	void insertReview(ReviewDTO reviewDTO) throws Exception;

}
