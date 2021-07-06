package com.busanit01.studyingp.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.busanit01.studyingp.dto.ClassDetailDTO;

@Repository
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

	@Override
	public int insertClsDetail(ClassDetailDTO clsDetailDTO) {
		return sqlSession.insert("mappers.ClassDetailMapper.insertClsDetail", clsDetailDTO);
	}

	@Override
	public int updateClsDetail(ClassDetailDTO clsDetailDTO) {
		return sqlSession.update("mappers.ClassDetailMapper.updateClsDetail", clsDetailDTO);
	}

	@Override
	public int deleteClsDetail(ClassDetailDTO clsDetailDTO) {
		return sqlSession.update("mappers.ClassDetailMapper.deleteClsDetail", clsDetailDTO);
	}

	@Override
	public int initDelClsDetail(ClassDetailDTO clsDetailDTO) {
		return sqlSession.delete("mappers.ClassDetailMapper.initDelClsDetail", clsDetailDTO);
	}
	
}
