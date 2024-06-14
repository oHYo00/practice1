package com.multi.spring.member.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.spring.member.model.dao.MemberDAO;
import com.multi.spring.member.model.dto.MemberDTO;


@EnableAspectJAutoProxy
@Transactional(rollbackFor = {Exception.class}) 
@Service
public class MemberServiceImpl implements MemberService{
	private final MemberDAO memberDAO;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private SqlSessionTemplate session;
	//--------------------------------------------------------- //@Autowired
	 public MemberServiceImpl(MemberDAO memberDAO) {
		 this.memberDAO =memberDAO; 
		 }
	 
	
//	@Override
//	public int insertMember(MemberDTO memberDTO) throws Exception{
//		int result=memberDAO.insertMember(session,memberDTO);
//		if(result<0) {
//			throw new Exception("회원가입실패");
//		}
//		return result;
//	}

	 @Override
		public int insertMember(MemberDTO memberDTO) throws Exception{
			
			
			System.out.println("암호환전 : "+memberDTO.getPw());
			
			String encpwString=bCryptPasswordEncoder.encode(memberDTO.getPw());
			memberDTO.setPw(encpwString);
			
			System.out.println("암호환후 : "+memberDTO.getPw());
			int result=memberDAO.insertMember(session,memberDTO);
			
			if(result<0) {
				throw new Exception("회원가입실패");
			}
			return result;
		}
	 

	@Override
	public ArrayList<MemberDTO> selectList() throws Exception{
		
		ArrayList<MemberDTO> list = memberDAO.selectList(session);
		return list;
	}


	@Override
	public int deleteMember(String id) throws Exception {
		int result=memberDAO.deleteMember(session,id);
		if(result<0) {
			throw new Exception("회원가입실패");
		}
		return result;
	}


	@Override
	public int updateMember(MemberDTO memberDTO) throws Exception {
		int result=memberDAO.updateMember(session,memberDTO);
		memberDAO.insertMember(session,memberDTO);
		if(result<0) {
			throw new Exception("회원수정실패");
		}
		return result;
	}


	@Override
	public MemberDTO selectOne(String id) throws Exception {
		MemberDTO dto = memberDAO.selectOne(session,id);
		return dto;
	}


//	@Override //암호화 처리전
//	public MemberDTO loginMember(MemberDTO memberDTO) throws Exception {
//		MemberDTO loginUser = memberDAO.loginMember(session,memberDTO);
//		
//		if(loginUser==null) {
//			throw new Exception("로그인 실패");
//		}
//		
//		return loginUser;
//	}
	
	@Override
	public MemberDTO loginMember(MemberDTO memberDTO) throws Exception {
		MemberDTO loginUser = memberDAO.loginMember(session,memberDTO);
		
		System.out.println(loginUser);
		
		if(loginUser==null) {
			throw new Exception("로그인 실패");
		}
		
		if(!bCryptPasswordEncoder.matches(memberDTO.getPw(), loginUser.getPw())) {
			
			throw new Exception("로그인 실패");
		}
		
		
		return loginUser;
	}
	
	
	
	
	

}
