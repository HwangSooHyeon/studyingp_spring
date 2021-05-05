package com.busanit01.studyingp.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.busanit01.studyingp.dto.BoardDTO;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<BoardDTO> selectBrd() {
		return sqlSession.selectList("mappers.BoardMapper.selectBrd");
	}
	@Override
	public List<BoardDTO> selectBrdAll() {
		return sqlSession.selectList("mappers.BoardMapper.selectBrdAll");
	}
	@Override
	public List<BoardDTO> selectBrdDel() {
		return sqlSession.selectList("mappers.BoardMapper.selectBrdDel");
	}
	@Override
	public BoardDTO selectBrdCode(BoardDTO boardDto) {
		return sqlSession.selectOne("mappers.BoardMapper.selectBrdCode");
	}
	@Override
	public BoardDTO selectBrdTitle(BoardDTO boardDto) {
		return sqlSession.selectOne("mappers.BoardMapper.selectBrdTitle");
	}
	@Override
	public List<BoardDTO> selectBrdContent(BoardDTO boardDto) {
		return sqlSession.selectList("mappers.BoardMapper.selectBrdCotent");
	}
	@Override
	public List<BoardDTO> selectBrdClsCode(BoardDTO boardDto) {
		return sqlSession.selectList("mappers.BoardMapper.selectBrdClsCode");
	}
	@Override
	public List<BoardDTO> selectBrdCategory(BoardDTO boardDto) {
		return sqlSession.selectList("mappers.BoardMapper.selectBrdCategory");
	}
	@Override
	public List<BoardDTO> selectBrdMemCode(BoardDTO boardDto) {
		return sqlSession.selectList("mappers.BoardMapper.selectBrdMemCode");
	}
	@Override
	public List<BoardDTO> selectBrdRating(BoardDTO boardDto) {
		return sqlSession.selectList("mappers.BoardMapper.selectBrdRating");
	}
	@Override
	public List<BoardDTO> selectBrdCmt(BoardDTO boardDto) {
		return sqlSession.selectList("mappers.BoardMapper.selectBrdCmt");
	}
	@Override
	public int insertBrd(BoardDTO boardDto) {
		int result = sqlSession.insert("mappers.BoardMapper.insertBrd", boardDto);
		sqlSession.commit();
		return result;
	}
	@Override
	public int updateBrd(BoardDTO boardDto) {
		int result = sqlSession.update("mappers.BoardMapper.updateBrd", boardDto);
		sqlSession.commit();
		return result;
	}
	@Override
	public int deleteBrd(BoardDTO boardDto) {
		int result = sqlSession.update("mappers.BoardMapper.deleteBrd", boardDto);
		sqlSession.commit();
		return result;
	}	
	
}