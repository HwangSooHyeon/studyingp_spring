package com.busanit01.studyingp.service;

import java.util.ArrayList;
import java.util.List;

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
	
	// 회원 권한 및 탈퇴 여부 수정
	public int updateUserAccess(MemberDTO memberDTO) throws Exception{
		return memDAO.updateMemAccess(memberDTO);
	}
	
	// 회원 탈퇴
	public int deleteUser(MemberDTO memberDTO) throws Exception{
		MemberDTO currentUser = signIn(memberDTO);
		return memDAO.deleteMem(currentUser);
	}

	// 회원 코드로 회원정보 가져오기(미탈퇴)
	public MemberDTO getMemByCode(MemberDTO memberDTO) throws Exception{
		return memDAO.selectMemCode(memberDTO);
	}
	
	// 회원 코드로 회원정보 가져오기(탈퇴포함)
	public MemberDTO getMemByCodeAll(MemberDTO memberDTO) throws Exception{
		return memDAO.selectMemCodeAll(memberDTO);
	}
	
	// 회원 아이디로 회원정보 가져오기
	public MemberDTO getMemById(MemberDTO memberDTO) throws Exception{
		return memDAO.selectMemId(memberDTO);
	}
	
	// 회원 이름으로 회원정보 가져오기
	public List<MemberDTO> getMemByName(MemberDTO memberDTO) throws Exception{
		return memDAO.selectMemName(memberDTO);
	}
	
	// 회원 검색 메소드
	public List<MemberDTO> searchMem(String searchCon, String searchWord){
		List<MemberDTO> memList = new ArrayList<MemberDTO>();
		MemberDTO memDTO = new MemberDTO();
		
		if(searchCon.equals("searchMem")) {
			return memDAO.selectMem();
		}else if(searchCon.equals("searchMemAll")) {
			return memDAO.selectMemAll();
		}else if(searchCon.equals("searchMemDel")) {
			return memDAO.selectMemDel();
		}else if(searchCon.equals("mem_code")) {
			memDTO.setMem_code(Integer.valueOf(searchWord));
			memList.add(memDAO.selectMemCode(memDTO));
			return memList;
		}else if(searchCon.equals("mem_id")) {
			memDTO.setMem_id(searchWord);
			memList.add(memDAO.selectMemId(memDTO));
			return memList;
		}else if(searchCon.equals("mem_name")) {
			memDTO.setMem_name(searchWord);
			return memDAO.selectMemName(memDTO);
		}else if(searchCon.equals("mem_access")) {
			memDTO.setMem_access(Integer.valueOf(searchWord));
			return memDAO.selectMemAccess(memDTO);
		}else {
			return null;
		}
	}
}
