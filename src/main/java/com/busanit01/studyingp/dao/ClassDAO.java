package com.busanit01.studyingp.dao;

import java.util.List;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.dto.MemberDTO;

public interface ClassDAO {

	public List<ClassDTO> selectCls();
	public List<ClassDTO> selectClsAll();
	public List<ClassDTO> selectClsDel();
	public List<ClassDTO> selectClsCategory(ClassDTO classDto);
	public List<ClassDTO> selectClsName(ClassDTO classDto);
	public List<ClassDTO> selectClsInst(MemberDTO memberDto);
	public List<ClassDTO> selectClsInstCode(ClassDTO classDto);
	public List<ClassDTO> selectClsNameWithCat(ClassDTO classDto);
	public List<ClassDTO> selectClsInstWithCat(ClassDTO classDto, MemberDTO memberDto);
	public ClassDTO selectClsAfterUpload(ClassDTO classDto);
	
	public ClassDTO selectClsCode(ClassDTO classDto);
	
	public int insertCls(ClassDTO classDto);
	public int updateCls(ClassDTO classDto);
	public int deleteCls(ClassDTO classDto);		
}
