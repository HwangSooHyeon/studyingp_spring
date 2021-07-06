package com.busanit01.studyingp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanit01.studyingp.dao.ClassDAO;
import com.busanit01.studyingp.dao.ClassDetailDAO;
import com.busanit01.studyingp.dao.MemberDAO;
import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.dto.ClassDetailDTO;
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
	private ClassDetailDAO clsDetailDAO;
	
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
	public int uploadCls(ClassDTO clsDTO, MemberDTO memDTO) {
		ClassDetailDTO clsDetailDTO = new ClassDetailDTO();
		
		// 강의 업로드
		int result = clsDAO.insertCls(clsDTO);
		
		if(result == 1) {
			// clsDTO에 cls_code 할당
			clsDTO = clsDAO.selectClsAfterUpload(clsDTO);
			
			// 총 강의 차수에 맞게 classDetail 테이블에 데이터 생성
			for(int i = 0; i < clsDTO.getCls_totlect(); i++){
				clsDetailDTO.setMem_code(memDTO.getMem_code());
				clsDetailDTO.setCls_code(clsDTO.getCls_code());
				clsDetailDTO.setClsd_lect(i+1);
				clsDetailDTO.setCls_totlect(clsDTO.getCls_totlect());
				
				int detailResult = clsDetailDAO.insertClsDetail(clsDetailDTO);
				
				if(detailResult == 1) {
					continue;
				}else {
					// 데이터 생성 중 에러 발생 시 생성한거 전부 delete 후 db생성 실패 반환
					int initDelResult = clsDetailDAO.initDelClsDetail(clsDetailDTO);
					if(initDelResult == 1) {
						System.out.println("DB에 임시 데이터 생성 중 에러가 발생하여 삭제했습니다. 강의번호: " + clsDTO.getCls_code());
						return 0;
					}else {
						System.out.println("DB에 임시 데이터 생성 중 에러가 발생하여 삭제를 시도했지만 실패했습니다. 강의번호: " + clsDTO.getCls_code());
						return 0;
					}					
				}
			}
			System.out.println("강의 업로드 및 임시 데이터 생성을 성공했습니다. 강의번호: " + clsDTO.getCls_code());
			return result;
		}else {
			System.out.println("CLASSTBL에 업로드를 실패했습니다. 강의번호: " + clsDTO.getCls_code());
			return result;
		}
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
	
	// 카테고리로 강의 검색
	public List<ClassDTO> searchClsCategory(String clsCategory){
		ClassDTO clsDTO = new ClassDTO();
		clsDTO.setCls_category(clsCategory);
		return clsDAO.selectClsCategory(clsDTO);
	}
	
	// 정해진 카테고리 내에서 강의 검색 메소드
	public List<ClassDTO> searchClsWithCategory(
			String searchCon, String searchWord, String clsCategory){
		ClassDTO clsDTO = new ClassDTO();
		
		if(searchCon.equals("cls_name")) {
			clsDTO.setCls_name(searchWord);
			clsDTO.setCls_category(clsCategory);
			return clsDAO.selectClsNameWithCat(clsDTO);
		}else if(searchCon.equals("mem_name")) {
			MemberDTO memDTO = new MemberDTO();
			memDTO.setMem_name(searchWord);
			clsDTO.setCls_category(clsCategory);
			return clsDAO.selectClsInstWithCat(clsDTO, memDTO);
		}else {
			return null;
		}
	}
	
}
