package com.multi.spring.bbs.service;

import java.util.List;

import com.multi.spring.bbs.model.dto.BbsDTO;
import com.multi.spring.page.model.dto.PageDTO;

public interface BbsService {

	void insertBbs(BbsDTO bbsDTO)throws Exception;

	List<BbsDTO> selectAll(PageDTO pageDTO)throws Exception;

	int selectCount()throws Exception;

	BbsDTO selectOne(BbsDTO bbsDTO)throws Exception;

}
