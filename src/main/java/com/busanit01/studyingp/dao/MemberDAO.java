package com.busanit01.studyingp.dao;

import java.util.List;

import com.busanit01.studyingp.dto.MemberDTO;

public interface MemberDAO {

	// 활동회원검색
	public List<MemberDTO> selectMem();
	// 탈퇴포함 전체회원검색
	public List<MemberDTO> selectMemAll();
	// 탈퇴회원검색
	public List<MemberDTO> selectMemDel();
	// 코드검색
	public MemberDTO selectMemCode(MemberDTO memberDto);
	// 아이디검색
	public MemberDTO selectMemId(MemberDTO memberDto);
	// 이름검색
	public MemberDTO selectMemName(MemberDTO memberDto);
	// 권한검색
	public List<MemberDTO> selectMemAccess(MemberDTO memberDto);

	//회원가입
	public int insertMem(MemberDTO memberDto);
	//정보수정
	public int updateMem(MemberDTO memberDto);
	//탈퇴
	public int deleteMem(MemberDTO memberDto);
	//권한변경
	public int updateMemAccess(MemberDTO memberDto);
	
}