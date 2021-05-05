package com.busanit01.studyingp.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.busanit01.studyingp.dto.CommentDTO;

@Repository
public class CommentDAOImpl implements CommentDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<CommentDTO> selectCmtInst(CommentDTO commentDto) {
		return sqlSession.selectList("mappers.CommentMapper.selectCmtInst");
	}
	@Override
	public int insertCmt(CommentDTO commentDto) {
		int result = sqlSession.insert("mappers.CommentMapper.insertCmt", commentDto);
		sqlSession.commit();
		return result;
	}
	@Override
	public int updateCmt(CommentDTO commentDto) {
		int result = sqlSession.update("mappers.CommentMapper.updateCmt", commentDto);
		sqlSession.commit();
		return result;
	}
	@Override
	public int deleteCmt(CommentDTO commentDto) {
		int result = sqlSession.update("mappers.CommentMapper.deleteCmt", commentDto);
		sqlSession.commit();
		return result;
	}	
}