package com.busanit01.studyingp.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.busanit01.studyingp.dto.ClassDTO;

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
		return sqlSession.selectList("mappers.ClassMapper.selectAll");
	}

	@Override
	public List<ClassDTO> selectClsDel() {
		return sqlSession.selectList("mappers.ClassMapper.selectDel");
	}

	@Override
	public List<ClassDTO> selectClsCategory(ClassDTO classDto) {
		return sqlSession.selectList("mappers.ClassMapper.selectClsCategory");
	}

	@Override
	public List<ClassDTO> selectClsName(ClassDTO classDto) {
		return sqlSession.selectList("mappers.ClassMapper.selectClsName");
	}

	@Override
	public List<ClassDTO> selectClsInst(ClassDTO classDto) {
		return sqlSession.selectList("mappers.ClassMapper.selectClsInst");
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
}
