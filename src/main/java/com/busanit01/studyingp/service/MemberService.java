package com.busanit01.studyingp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanit01.studyingp.dao.MemberDAO;
import com.busanit01.studyingp.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memDAO;
	
	// 로그인 메소드
	public MemberDTO signIn(MemberDTO memberDTO) throws Exception {		
		return memDAO.signIn(memberDTO);
	}
	
	// 회원가입 메소드
	public int signUp(MemberDTO memberDTO) throws Exception {
		return memDAO.insertMem(memberDTO);
	}
	
	// 아이디 중복 체크 메소드
	public int idChk(MemberDTO memberDTO) throws Exception{
		return memDAO.idChk(memberDTO);
	}
}
