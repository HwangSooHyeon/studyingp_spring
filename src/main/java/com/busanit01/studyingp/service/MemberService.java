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
}
