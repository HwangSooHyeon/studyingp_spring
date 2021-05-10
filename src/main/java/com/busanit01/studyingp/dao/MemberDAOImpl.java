package com.busanit01.studyingp.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.busanit01.studyingp.dto.MemberDTO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<MemberDTO> selectMem() {
		return sqlSession.selectList("mappers.MemberMapper.selectMem");
	}
	@Override
	public List<MemberDTO> selectMemAll() {
		return sqlSession.selectList("mappers.MemberMapper.selectMemAll");
	}
	@Override
	public List<MemberDTO> selectMemDel() {
		return sqlSession.selectList("mappers.MemberMapper.selectMemDel");
	}
	@Override
	public MemberDTO selectMemCode(MemberDTO memberDto) {
		return sqlSession.selectOne("mappers.MemberMapper.selectMemCode");
	}
	@Override
	public MemberDTO selectMemId(MemberDTO memberDto) {
		return sqlSession.selectOne("mappers.MemberMapper.selectMemId");
	}
	@Override
	public MemberDTO selectMemName(MemberDTO memberDto) {
		return sqlSession.selectOne("mappers.MemberMapper.selectMemName");
	}
	@Override
	public List<MemberDTO> selectMemAccess(MemberDTO memberDto) {
		return sqlSession.selectList("mappers.MemberMapper.selectMemAccess");
	}
	@Override
	public int insertMem(MemberDTO memberDto) {
		int result = sqlSession.insert("mappers.MemberMapper.insertMem", memberDto);
		sqlSession.commit();
		return result;
	}
	@Override
	public int updateMem(MemberDTO memberDto) {
		int result = sqlSession.update("mappers.MemberMapper.updateMem", memberDto);
		sqlSession.commit();
		return result;
	}
	@Override
	public int deleteMem(MemberDTO memberDto) {
		int result = sqlSession.update("mappers.MemberMapper.deleteMem", memberDto);
		sqlSession.commit();
		return result;
	}
	@Override
	public int updateMemAccess(MemberDTO memberDto) {
		int result = sqlSession.update("mappers.MemberMapper.updateMemAccess", memberDto);
		sqlSession.commit();
		return result;
	}
	@Override
	public MemberDTO signIn(MemberDTO memberDto) throws Exception{
		return sqlSession.selectOne("mappers.MemberMapper.signIn", memberDto);
	}
	
	
}