package com.multi.spring.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.member.model.dto.MemberDTO;

@Repository
public class MemberDAO {


	public int insertMember(SqlSessionTemplate session, MemberDTO memberDTO)throws Exception {
		// TODO Auto-generated method stub
		return session.insert("insertMember",memberDTO);
	}

	public ArrayList<MemberDTO> selectList(SqlSessionTemplate session) throws Exception{
		// TODO Auto-generated method stub
		return (ArrayList)session.selectList("selectList");
	}

	public int deleteMember(SqlSessionTemplate session, String id)throws Exception {
		// TODO Auto-generated method stub
		return session.delete("deleteMember",id);
	}

	public int updateMember(SqlSessionTemplate session, MemberDTO memberDTO)throws Exception {
		// TODO Auto-generated method stub
		return session.update("updateMember",memberDTO);
	}

	public MemberDTO selectOne(SqlSessionTemplate session, String id) {
		// TODO Auto-generated method stub
		return session.selectOne("selectMember",id);
	}

	public MemberDTO loginMember(SqlSessionTemplate session, MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return session.selectOne("memberMapper.loginMember",memberDTO);
	}
}
