package com.busanit01.studyingp.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;

import com.busanit01.studyingp.dto.ClassDetailDTO;

public class ClassDetailDAOImpl implements ClassDetailDAO{
	@Inject
	private SqlSession sqlSession;

	@Override
	public List<ClassDetailDTO> selectClsDetail() {
		return sqlSession.selectList("mappers.ClassDetailMapper.selectClsDetail");
	}

	@Override
	public List<ClassDetailDTO> selectClsDetailAll() {
		return sqlSession.selectList("mappers.ClassDetailMapper.selectClsDetailAll");
	}

	@Override
	public List<ClassDetailDTO> selectClsDetailDel() {
		return sqlSession.selectList("mappers.ClassDetailMapper.selectClsDetailDel");
	}

	@Override
	public ClassDetailDTO selectClsDetailCode(ClassDetailDTO clsDetailDTO) {
		return sqlSession.selectOne("mappers.ClassDetailMapper.selectClsDetailCode", clsDetailDTO);
	}

	@Override
	public List<ClassDetailDTO> selectClsDetailClsCode(ClassDetailDTO clsDetailDTO) {
		return sqlSession.selectList("mappers.ClassDetailMapper.selectClsDetailClsCode", clsDetailDTO);
	}

	@Override
	public ClassDetailDTO selectClsDetailClsNLect(ClassDetailDTO clsDetailDTO) {
		return sqlSession.selectOne("mappers.ClassDetailMapper.selectClsDetailClsNLect", clsDetailDTO);
	}

	@Override
	public List<ClassDetailDTO> selectClsDetailMemCode(ClassDetailDTO clsDetailDTO) {
		return sqlSession.selectList("mappers.ClassDetailMapper.selectClsDetailMemCode", clsDetailDTO);
	}
	
}
