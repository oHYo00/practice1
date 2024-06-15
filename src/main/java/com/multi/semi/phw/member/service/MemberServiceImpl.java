package com.multi.semi.phw.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.multi.spring.member.model.dao.MemberDAO;
import com.multi.spring.member.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {
	
	private final MemberDAO memberDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public MemberServiceImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

//	@Override
//	public void insertMember(MemberDTO memberDTO) throws Exception {
//		// TODO Auto-generated method stub
//		int result = memberDAO.insertMember(sqlSession, memberDTO);
//		if(result < 0) {
//			throw new Exception("회원가입에 실패 하였습니다.");
//		}
//		
//	}


	@Override
	public List<MemberDTO> selectList() throws Exception {
		// TODO Auto-generated method stub
		List<MemberDTO> list = memberDAO.selectList(sqlSession);
		return list;
	}

	@Override
	public void deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub
		int result = memberDAO.deleteMember(sqlSession, id);
		if(result < 0) {
			throw new Exception("회원삭제에 실패 하였습니다.");
		}
		
	}

	@Override
	public void updateMember(MemberDTO memberDTO) throws Exception {
		// TODO Auto-generated method stub
		int result = memberDAO.updateMember(sqlSession, memberDTO);
		if(result < 0) {
			throw new Exception("회원수정에 실패 하였습니다.");
		}
		
	}

	@Override
	public MemberDTO selectMember(String id) throws Exception {
		// TODO Auto-generated method stub
		MemberDTO dto = memberDAO.selectMember(sqlSession, id);
		return dto;
	}

	//로그인 암호화 처리 전 
//	@Override
//	public MemberDTO loginMember(MemberDTO m) throws Exception {
//		// TODO Auto-generated method stub
//		MemberDTO loginUser = memberDAO.loginMember(sqlSession, m);
//		
//		if(loginUser == null) {
//			throw new Exception("loginUser 정보 확인, 로그인 실패");
//		}
//		return loginUser;
//	}
	
	
	
	@Override
	public MemberDTO loginMember(MemberDTO m) throws Exception {
		
		MemberDTO loginUser = memberDAO.loginMember(sqlSession, m);
		
		if(loginUser == null) {
			throw new Exception("loginUser 정보 확인, 로그인 실패");
		}
		
		if(!bCryptPasswordEncoder.matches(m.getPw(), loginUser.getPw())){
			throw new Exception("암호불일치~!!");
		}
		return loginUser;
	}
	
	
	//로그인 암호화 처리 후
	@Override
	public void insertMember(MemberDTO m) throws Exception {
		
		System.out.println("암호화전 : " + m.getPw());
		
		String encpw = bCryptPasswordEncoder.encode(m.getPw());
		
		System.out.println("암호화후 : " + encpw);
		
		m.setPw(encpw);
		int result = memberDAO.insertMember(sqlSession, m);
		if(result < 0) {
			throw new Exception("회원가입에 실패 하였습니다.");
		}
	}
	

}
