package com.multi.spring.bbs.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.spring.bbs.model.dao.BbsDAO;
import com.multi.spring.bbs.model.dto.BbsDTO;
import com.multi.spring.page.model.dto.PageDTO;


@Service
public class BbsServiceImpl implements BbsService{

	@Autowired
	private BbsDAO bbsDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public void insertBbs(BbsDTO bbsDTO) throws Exception {
		
	int reslut=	bbsDAO.insertBbs(sqlSession,bbsDTO);
	}

	@Override
	public List<BbsDTO> selectAll(PageDTO pageDTO) throws Exception {
		List<BbsDTO>list=bbsDAO.selectAll(sqlSession,pageDTO);
		return list;
	}

	@Override
	public int selectCount() throws Exception {
		int count=bbsDAO.selectCount(sqlSession);
		return count;
	}

	@Override
	public BbsDTO selectOne(BbsDTO bbsDTO) throws Exception {
		// TODO Auto-generated method stub
		BbsDTO dto=bbsDAO.selectOne(sqlSession,bbsDTO);
		return dto;
	}

}
