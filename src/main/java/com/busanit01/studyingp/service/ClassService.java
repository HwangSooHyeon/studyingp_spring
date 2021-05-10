package com.busanit01.studyingp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanit01.studyingp.dao.ClassDAO;
import com.busanit01.studyingp.dto.ClassDTO;

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
}
