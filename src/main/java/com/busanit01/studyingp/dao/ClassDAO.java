package com.busanit01.studyingp.dao;

import java.util.List;

import com.busanit01.studyingp.dto.ClassDTO;

public interface ClassDAO {

	public List<ClassDTO> selectCls();
	public List<ClassDTO> selectClsAll();
	public List<ClassDTO> selectClsDel();
	public List<ClassDTO> selectClsCategory(ClassDTO classDto);
	public List<ClassDTO> selectClsName(ClassDTO classDto);
	public List<ClassDTO> selectClsInst(ClassDTO classDto);
	
	public ClassDTO selectClsCode(ClassDTO classDto);
	
	public int insertCls(ClassDTO classDto);
	public int updateCls(ClassDTO classDto);
	public int deleteCls(ClassDTO classDto);		
}
