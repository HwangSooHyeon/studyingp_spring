package com.busanit01.studyingp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanit01.studyingp.dao.MemberDAO;
import com.busanit01.studyingp.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	private MemberDAO memDAO;
	
	// 로그인
	public MemberDTO signIn(MemberDTO memberDTO) throws Exception {		
		return memDAO.signIn(memberDTO);
	}
	
	// 회원가입
	public int signUp(MemberDTO memberDTO) throws Exception {
		return memDAO.insertMem(memberDTO);
	}
	
	// 아이디 중복 체크
	public int idChk(MemberDTO memberDTO) throws Exception {
		return memDAO.idChk(memberDTO);
	}
	
	// 비밀번호 체크
	public int pwChk(MemberDTO memberDTO) throws Exception {
		return memDAO.pwChk(memberDTO);
	}
	
	// 회원정보 수정
	public int updateUserInfo(MemberDTO memberDTO) throws Exception{
		return memDAO.updateMem(memberDTO);
	}
	
	// 회원 탈퇴
	public int deleteUser(MemberDTO memberDTO) throws Exception{
		MemberDTO currentUser = signIn(memberDTO);
		return memDAO.deleteMem(currentUser);
	}

	// 회원 코드로 회원정보 가져오기
	public MemberDTO getMemByCode(MemberDTO memberDTO) throws Exception{
		return memDAO.selectMemCode(memberDTO);
	}
	
	// 회원 아이디로 회원정보 가져오기
	public MemberDTO getMemById(MemberDTO memberDTO) throws Exception{
		return memDAO.selectMemId(memberDTO);
	}
	
}
