package com.busanit01.studyingp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanit01.studyingp.dao.ClassDAO;
import com.busanit01.studyingp.dao.ClassDetailDAO;
import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.dto.ClassDetailDTO;

@Service
public class ClassDetailService {
	@Autowired
	private ClassDAO clsDAO;
	
	@Autowired
	private ClassDetailDAO clsDetailDAO;
	
	// 강의 코드로 해당 강의 회차 전부 불러오는 메소드
	public List<ClassDetailDTO> getClsDetailByClsCode(String cls_code){
		ClassDetailDTO clsDetailDTO = new ClassDetailDTO();
		
		clsDetailDTO.setCls_code(Integer.valueOf(cls_code));
		
		return clsDetailDAO.selectClsDetailClsCode(clsDetailDTO);
	}
	
}
