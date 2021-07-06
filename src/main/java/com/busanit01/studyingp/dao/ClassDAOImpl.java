package com.busanit01.studyingp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.busanit01.studyingp.dto.ClassDTO;
import com.busanit01.studyingp.dto.MemberDTO;

@Repository
public class ClassDAOImpl implements ClassDAO{
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<ClassDTO> selectCls() {
		return sqlSession.selectList("mappers.ClassMapper.selectCls");
	}

	@Override
	public List<ClassDTO> selectClsAll() {
		return sqlSession.selectList("mappers.ClassMapper.selectClsAll");
	}

	@Override
	public List<ClassDTO> selectClsDel() {
		return sqlSession.selectList("mappers.ClassMapper.selectClsDel");
	}

	@Override
	public List<ClassDTO> selectClsCategory(ClassDTO classDto) {
		return sqlSession.selectList("mappers.ClassMapper.selectClsCategory", classDto);
	}

	@Override
	public List<ClassDTO> selectClsName(ClassDTO classDto) {
		return sqlSession.selectList("mappers.ClassMapper.selectClsName", classDto);
	}

	@Override
	public List<ClassDTO> selectClsInst(MemberDTO memberDto) {
		return sqlSession.selectList("mappers.ClassMapper.selectClsInst", memberDto);
	}

	@Override
	public int insertCls(ClassDTO classDto) {
		return sqlSession.insert("mappers.ClassMapper.insertCls", classDto);
	}

	@Override
	public int updateCls(ClassDTO classDto) {
		return sqlSession.update("mappers.ClassMapper.updateCls", classDto);
	}

	@Override
	public int deleteCls(ClassDTO classDto) {
		return sqlSession.update("mappers.ClassMapper.deleteCls", classDto);
	}

	@Override
	public ClassDTO selectClsCode(ClassDTO classDto) {
		return sqlSession.selectOne("mappers.ClassMapper.selectClsCode", classDto);
	}

	@Override
	public List<ClassDTO> selectClsInstCode(ClassDTO classDto) {
		return sqlSession.selectList("mappers.ClassMapper.selectClsInstCode", classDto);
	}

	@Override
	public List<ClassDTO> selectClsNameWithCat(ClassDTO classDto) {
		return sqlSession.selectList("mappers.ClassMapper.selectClsNameWithCat", classDto);
	}

	@Override
	public List<ClassDTO> selectClsInstWithCat(ClassDTO classDto, MemberDTO memberDto) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_name", memberDto.getMem_name());
		params.put("cls_category", classDto.getCls_category());
		
		return sqlSession.selectList("mappers.ClassMapper.selectClsInstWithCat", params);
	}

	@Override
	public ClassDTO selectClsAfterUpload(ClassDTO classDto) {
		return sqlSession.selectOne("mappers.ClassMapper.selectClsAfterUpload", classDto);
	}		
}
