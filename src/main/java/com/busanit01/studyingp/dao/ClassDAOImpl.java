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
		return sqlSession.selectList("selectCls");
	}

	@Override
	public List<ClassDTO> selectClsAll() {
		return sqlSession.selectList("selectAll");
	}

	@Override
	public List<ClassDTO> selectClsDel() {
		return sqlSession.selectList("selectDel");
	}

	@Override
	public List<ClassDTO> selectClsCategory(ClassDTO classDto) {
		return sqlSession.selectList("selectClsCategory");
	}

	@Override
	public List<ClassDTO> selectClsName(ClassDTO classDto) {
		return sqlSession.selectList("selectClsName");
	}

	@Override
	public List<ClassDTO> selectClsInst(ClassDTO classDto) {
		return sqlSession.selectList("selectClsInst");
	}

	@Override
	public int insertCls(ClassDTO classDto) {
		int result = sqlSession.insert("insertCls", classDto);
		sqlSession.commit();
		return result;
	}

	@Override
	public int updateCls(ClassDTO classDto) {
		int result = sqlSession.update("updateCls", classDto);
		sqlSession.commit();
		return result;
	}

	@Override
	public int deleteCls(ClassDTO classDto) {
		int result = sqlSession.update("deleteCls", classDto);
		sqlSession.commit();
		return result;
	}

	@Override
	public ClassDTO selectClsCode(ClassDTO classDto) {
		return sqlSession.selectOne("selectClsCode", classDto);
	}
	
}
