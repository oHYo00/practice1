package com.multi.spring.member.service;

import java.util.ArrayList;


import com.multi.spring.member.model.dto.MemberDTO;

public interface MemberService {
	public int insertMember(MemberDTO memberDTO) throws Exception;

	public ArrayList<MemberDTO> selectList() throws Exception;

	public int deleteMember(String id)throws Exception;

	public int updateMember(MemberDTO memberDTO)throws Exception;

	public MemberDTO selectOne(String id)throws Exception;

	public MemberDTO loginMember(MemberDTO memberDTO)throws Exception;

	

}
