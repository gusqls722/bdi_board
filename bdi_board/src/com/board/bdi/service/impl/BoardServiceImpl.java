package com.board.bdi.service.impl;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.board.bdi.common.DBConnection;
import com.board.bdi.common.ParseUtil;
import com.board.bdi.common.UploadFiles;
import com.board.bdi.dao.BoardDAO;
import com.board.bdi.dao.impl.BoardDAOImpl;
import com.board.bdi.service.BoardService;
import com.board.bdi.vo.BoardInfoVo;
import com.board.bdi.vo.CommentInfoVo;
import com.board.bdi.vo.PageInfo;

public class BoardServiceImpl implements BoardService {
	private BoardDAO bdao = new BoardDAOImpl();
	
	@Override
	public void selectBoardList(HttpServletRequest req) throws SQLException, ServletException {
		BoardInfoVo bi = ParseUtil.parseRequest(req, BoardInfoVo.class);
		bdao.setCon(DBConnection.getCon());
		try {
			PageInfo pi = bi.getPi();
			pi.setTotalCnt(bdao.countBoardList());
			pi.pageCount();
			req.setAttribute("pi", pi);
			req.setAttribute("biList", bdao.selectBoardList(bi));
		}catch(SQLException e) {
			throw e;
		}finally {
			DBConnection.close();
		}
	}

	@Override
	public void selectBoard(HttpServletRequest req) throws SQLException, ServletException {
		BoardInfoVo bi = ParseUtil.parseRequest(req, BoardInfoVo.class);
		bdao.setCon(DBConnection.getCon());
		try {
			bdao.updateBoardCnt(bi);
			CommentInfoVo ci = new CommentInfoVo();
			ci.setBinum(bi.getBinum());
			req.setAttribute("ciList", bdao.selectCommentList(ci));
			req.setAttribute("bi", bdao.selectBoard(bi));
			DBConnection.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBConnection.close();
		}
	}

	@Override
	public void insertBoard(HttpServletRequest req) throws SQLException, ServletException {
		Map<String,String> params = UploadFiles.saveFileList(req);
		BoardInfoVo bi = new BoardInfoVo();
		bi.setBitable(params.get("bitable"));
		bi.setBitext(params.get("bitext"));
		bi.setBifile(params.get("bifile"));
		bi.setUinum(Integer.parseInt(params.get("uinum")));
		System.out.println(bi);
		bdao.setCon(DBConnection.getCon());
		try {
			req.setAttribute("cnt", bdao.insertBoard(bi));
			DBConnection.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBConnection.close();
		}
	}

	@Override
	public void updateBoard(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectCommentList(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectComment(HttpServletRequest req) throws SQLException, ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertComment(HttpServletRequest req) throws SQLException, ServletException {
		CommentInfoVo ci = ParseUtil.parseRequest(req, CommentInfoVo.class);
		bdao.setCon(DBConnection.getCon());
		try {
			BoardInfoVo bi = new BoardInfoVo();
			bi.setBinum(ci.getBinum());
			req.setAttribute("bi", bdao.selectBoard(bi));
			req.setAttribute("ciCnt", bdao.insertCommment(ci));
			req.setAttribute("ciList", bdao.selectCommentList(ci));
			DBConnection.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBConnection.close();
		}
	}

	@Override
	public void deleteComment(HttpServletRequest req) throws SQLException, ServletException {
		CommentInfoVo ci = ParseUtil.parseRequest(req, CommentInfoVo.class);
		bdao.setCon(DBConnection.getCon());
		try {
			BoardInfoVo bi = new BoardInfoVo();
			bi.setBinum(ci.getBinum());
			req.setAttribute("ciDelCnt", bdao.deleteComment(ci));
			req.setAttribute("bi", bdao.selectBoard(bi));
			req.setAttribute("ciList", bdao.selectCommentList(ci));
			DBConnection.commit();
		}catch(SQLException e) {
			throw e;
		}finally {
			DBConnection.close();
		}
		
	}

}