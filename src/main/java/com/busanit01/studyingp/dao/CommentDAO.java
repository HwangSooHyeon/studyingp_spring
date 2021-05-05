package com.busanit01.studyingp.dao;

import java.util.List;

import com.busanit01.studyingp.dto.CommentDTO;

public interface CommentDAO {

	// 댓글 조회(회원코드)
	public List<CommentDTO> selectCmtInst(CommentDTO commentDto);
	// 댓글 등록
	public int insertCmt(CommentDTO commentDto);
	// 댓글 수정
	public int updateCmt(CommentDTO commentDto);
	// 댓글 삭제
	public int deleteCmt(CommentDTO commentDto);
	
	
}