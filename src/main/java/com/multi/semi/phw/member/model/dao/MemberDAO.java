package com.multi.spring.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.multi.spring.member.model.dto.MemberDTO;

@Repository //@Repository -> dao의 역할에 기능까지 추가한거
public class MemberDAO {
	public int insertMember(SqlSessionTemplate sqlSession, MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return sqlSession.insert("memberMapper.insertMember", memberDTO);
		
	}
	
	public List<MemberDTO> selectList(SqlSessionTemplate sqlSession) {
		// TODO Auto-generated method stub
		return (List)sqlSession.selectList("memberMapper.selectList");
		
	}

	public int deleteMember(SqlSessionTemplate sqlSession, String id) {
		// TODO Auto-generated method stub
		return sqlSession.delete("memberMapper.deleteMember", id);
	}

	public int updateMember(SqlSessionTemplate sqlSession, MemberDTO memberDTO) {
		// TODO Auto-generated method stub
		return sqlSession.update("memberMapper.updateMember", memberDTO);
	}

	public MemberDTO selectMember(SqlSessionTemplate sqlSession, String id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("memberMapper.selectMember", id);
	}

	public MemberDTO loginMember(SqlSessionTemplate sqlSession, MemberDTO m) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}

	

}









