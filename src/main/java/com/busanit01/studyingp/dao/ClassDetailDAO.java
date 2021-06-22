package com.busanit01.studyingp.dao;

import java.util.List;

import com.busanit01.studyingp.dto.ClassDetailDTO;

public interface ClassDetailDAO {
	public List<ClassDetailDTO> selectClsDetail();
	public List<ClassDetailDTO> selectClsDetailAll();
	public List<ClassDetailDTO> selectClsDetailDel();
	
	public ClassDetailDTO selectClsDetailCode(ClassDetailDTO clsDetailDTO);
	
	public List<ClassDetailDTO> selectClsDetailClsCode(ClassDetailDTO clsDetailDTO);
	
	public ClassDetailDTO selectClsDetailClsNLect(ClassDetailDTO clsDetailDTO);
	
	public List<ClassDetailDTO> selectClsDetailMemCode(ClassDetailDTO clsDetailDTO);
}
