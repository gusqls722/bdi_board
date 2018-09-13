package com.board.bdi.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.board.bdi.vo.BoardInfoVo;
import com.board.bdi.vo.CommentInfoVo;

public interface BoardDAO {
	public void setCon(Connection con);
	public int insertBoard(BoardInfoVo bi) throws SQLException;
	public int updateBoardCnt(BoardInfoVo bi) throws SQLException;
	public BoardInfoVo selectBoard(BoardInfoVo bi)throws SQLException;
	public List<BoardInfoVo> selectBoardList(BoardInfoVo bi)throws SQLException;
	
	public int insertCommment(CommentInfoVo ci)throws SQLException;	
	public CommentInfoVo selectComment(CommentInfoVo ci)throws SQLException;
	public List<CommentInfoVo> selectCommentList(CommentInfoVo ci)throws SQLException;
	public int deleteComment(CommentInfoVo ci) throws SQLException;
	
	public int countBoardList() throws SQLException;
}