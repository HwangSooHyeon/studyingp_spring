package com.busanit01.studyingp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanit01.studyingp.dao.ClassDAO;
import com.busanit01.studyingp.dto.ClassDTO;

@Service
public class ClassService {

	@Autowired
	private ClassDAO clsDAO;
	
	public ClassDTO test(ClassDTO clsDTO) {				
		return clsDAO.selectClsCode(clsDTO);
	}	
}
