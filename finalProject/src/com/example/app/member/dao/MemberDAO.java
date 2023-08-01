package com.example.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.example.app.member.dto.MemberDTO;
import com.mybatis.config.MyBatisConfig;

public class MemberDAO {
	public SqlSession sqlSession;
	
	
	public MemberDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	public void join(MemberDTO memberDTO) {
		sqlSession.insert("member.join",memberDTO);
	}
	
	public boolean checkId(String memberId) {
		return (Integer)sqlSession.selectOne("member.checkId",memberId) <1;
	}
	
	public int login(MemberDTO memberDTO) {
//		Integer memberNumber =sqlSession.selectOne("member.login",memberDTO);
//		System.out.println(memberNumber);
//		return memberNumber ==null ? -1:memberNumber;
		
		return sqlSession.selectOne("member.login",memberDTO);
		 
	}
	
	public String getMemberId(int memberNumber) {
		return sqlSession.selectOne("member.getMemberId",memberNumber);
	}
	
}
