package com.busanit01.studyingp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanit01.studyingp.dao.ClassDAO;
import com.busanit01.studyingp.dao.MemberDAO;
import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.dto.MemberDTO;

@Service
public class ClassService {
	
	private final int CLS_FIRST = 1;
	private final int CLS_SECOND = 2;
	private final int CLS_THIRD = 3;
	private final int CLS_FOURTH = 4;
	private final int CLS_FIFTH = 5;
	private final int CLS_SIXTH = 6;
	
	@Autowired
	private ClassDAO clsDAO;
	
	@Autowired
	private MemberDAO memDAO;
	
	@Autowired
	private MemberService memberService;
	
	// 테스트 메소드
	public ClassDTO test() {
		ClassDTO clsDTO = new ClassDTO();
		clsDTO.setCls_code(1);
		return clsDAO.selectClsCode(clsDTO);
	}
	
	// 메인 화면의 강의 리스트를 받아오는 메소드
	public List<ClassDTO> mainClsList(){
		
		List<ClassDTO> classes = new ArrayList<ClassDTO>();
		
		for(int i = 0; i < 6; i++) {
			classes.add(new ClassDTO());
		}
		classes.get(0).setCls_code(CLS_FIRST);
		classes.set(0, clsDAO.selectClsCode(classes.get(0)));
		classes.get(1).setCls_code(CLS_SECOND);
		classes.set(1, clsDAO.selectClsCode(classes.get(1)));
		classes.get(2).setCls_code(CLS_THIRD);
		classes.set(2, clsDAO.selectClsCode(classes.get(2)));
		classes.get(3).setCls_code(CLS_FOURTH);
		classes.set(3, clsDAO.selectClsCode(classes.get(3)));
		classes.get(4).setCls_code(CLS_FIFTH);
		classes.set(4, clsDAO.selectClsCode(classes.get(4)));
		classes.get(5).setCls_code(CLS_SIXTH);
		classes.set(5, clsDAO.selectClsCode(classes.get(5)));
				
		return classes;
	}
	
	// 강의상세페이지로 넘어가는 메소드
	public ClassDTO srchClsByCode(ClassDTO clsDTO) {
		return clsDAO.selectClsCode(clsDTO);
	}
	
	// 강의 하나만 불러오는 메소드
	public ClassDTO getClsOne(String selClsCode) {
		ClassDTO clsDTO = new ClassDTO();
		clsDTO.setCls_code(Integer.valueOf(selClsCode));
		return clsDAO.selectClsCode(clsDTO);
	}
	
	// 강의 코드 쿠키를 이용해 강의를 불러오는 메소드
	public List<ClassDTO> getClsByCookie(String[] clsCodeArr) {
		List<ClassDTO> clsList = new ArrayList<ClassDTO>();
		
		for(int i = 0; i < clsCodeArr.length; i++) {
			clsList.add(new ClassDTO());
			clsList.get(i).setCls_code(Integer.valueOf(clsCodeArr[i]));
			clsList.set(i, clsDAO.selectClsCode(clsList.get(i)));
		}
		
		return clsList;
	}
	
	// 쿼리 스트링의 강의 코드를 이용해 강의를 불러오는 메소드(단일)
	public List<ClassDTO> getClsByQuery(String selClsCode) {
		ClassDTO clsDTO = new ClassDTO();
		clsDTO.setCls_code(Integer.valueOf(selClsCode));
		clsDTO = clsDAO.selectClsCode(clsDTO);
		
		List<ClassDTO> orderClsList = new ArrayList<ClassDTO>(); 
		orderClsList.add(clsDTO);
		
		return orderClsList;
	}	
	
	// 장바구니에서 강의를 삭제하는 메소드
	public String delClsCart(String selClsCode, String clsCode) {
		String[] clsCodeArr = clsCode.split("_");
		String reClsCode = "";
		int delIndex = 0;
		// 1. 선택한 강의 번호와 같은 번호를 쿠키에서 찾음
		for(int i = 0; i < clsCodeArr.length; i++) {
			if(clsCodeArr[i].equals(selClsCode)) {
				delIndex = i;
				break;
			}
		}
		// 2. 선택한 강의 번호와 같은 번호를 제외하고 재조립
		for(int i = 0; i < clsCodeArr.length; i++) {
			if(clsCodeArr.length == 1 && selClsCode.equals(clsCodeArr[0])) {
				break;
			}
			
			if(i == delIndex) {
				continue;
			}
			
			if(reClsCode.equals("")) {
				reClsCode = clsCodeArr[i];
			}else{
				reClsCode = reClsCode + "_" + clsCodeArr[i];
			}
		}
		
		return reClsCode;
	}
	
	// 강의를 업로드하는 메소드
	public int uploadCls(ClassDTO clsDTO) {
		return clsDAO.insertCls(clsDTO);
	}
	
	// 강의 검색 메소드
	public List<ClassDTO> searchCls(String searchCon, String searchWord){
		List<ClassDTO> clsList = new ArrayList<ClassDTO>();
		ClassDTO clsDTO = new ClassDTO();
		
		if(searchCon.equals("searchCls")) {
			return clsDAO.selectCls();			
		}else if(searchCon.equals("searchClsAll")){
			return clsDAO.selectClsAll();
		}else if(searchCon.equals("searchClsDel")){
			return clsDAO.selectClsDel();
		}else if(searchCon.equals("cls_code")){
			clsDTO.setCls_code(Integer.valueOf(searchWord));
			clsList.add(clsDAO.selectClsCode(clsDTO));
			return clsList;
		}else if(searchCon.equals("cls_category")) {
			clsDTO.setCls_category(searchWord);
			return clsDAO.selectClsCategory(clsDTO);
		}else if(searchCon.equals("cls_name")) {
			clsDTO.setCls_name(searchWord);
			return clsDAO.selectClsName(clsDTO);
		}else if(searchCon.equals("mem_code")){
			clsDTO.setMem_code(Integer.valueOf(searchWord));
			return clsDAO.selectClsInstCode(clsDTO);
		}else if(searchCon.equals("mem_name")) {
			MemberDTO memDTO = new MemberDTO();
			memDTO.setMem_name(searchWord);			
			return clsDAO.selectClsInst(memDTO);
		}else {
			return null;
		}
	}
	
	// 강의 수정 메소드
	public int updateCls(ClassDTO clsDTO) {
		return clsDAO.updateCls(clsDTO);
	}
}
