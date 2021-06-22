package com.busanit01.studyingp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busanit01.studyingp.dao.ClassDetailDAO;

@Service
public class ClassDetailService {

	@Autowired
	private ClassDetailDAO clsDetailDAO;
	
}
