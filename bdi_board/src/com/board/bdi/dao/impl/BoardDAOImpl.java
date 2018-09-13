package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.bdi.dao.BoardDAO;
import com.board.bdi.vo.BoardInfoVo;
import com.board.bdi.vo.CommentInfoVo;

public class BoardDAOImpl implements BoardDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public int insertBoard(BoardInfoVo bi) throws SQLException {
		String sql = "insert into board_info(bitable, bitext,bicredat, "
				+ "bimodat,bicnt, biactive, uinum,bifile)";
		sql += " values(?,?,now(),now(),0,1,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, bi.getBitable());
			ps.setString(2, bi.getBitext());
			ps.setInt(3, bi.getUinum());
			ps.setString(4, bi.getBifile());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public BoardInfoVo selectBoard(BoardInfoVo bi) throws SQLException {
		String sql = "select bi.*,ui.uiname \r\n" + 
				"from  board_info bi,\r\n" + 
				"user_info ui\r\n" + 
				"where \r\n" + 
				"ui.uinum = bi.uinum\r\n" + 
				"and bi.BINUM=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bi.getBinum());
			rs = ps.executeQuery();
			while(rs.next()) {
				bi = new BoardInfoVo();
				bi.setBinum(rs.getInt("binum"));
				bi.setBitable(rs.getString("bitable"));
				bi.setBitext(rs.getString("bitext"));
				bi.setBifile(rs.getString("bifile"));
				bi.setBicredat(rs.getString("bicredat"));
				bi.setBimodat(rs.getString("bimodat"));
				bi.setBicnt(rs.getInt("bicnt"));
				bi.setUinum(rs.getInt("uinum"));
				bi.setUiname(rs.getString("uiname"));
				return bi;
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		return null;
	}

	@Override
	public List<BoardInfoVo> selectBoardList(BoardInfoVo bi) throws SQLException {
		String sql = "select bi.*,ui.uiname from board_info bi,user_info ui"
				+ " where bi.uinum=ui.uinum"
				+ " order by binum desc limit ?,?";
		List<BoardInfoVo> biList = new ArrayList<BoardInfoVo>();
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,bi.getPi().getLimitFNum());
			ps.setInt(2,bi.getPi().getLimitLnum());
			rs = ps.executeQuery();
			while(rs.next()) {
				bi = new BoardInfoVo();
				bi.setBinum(rs.getInt("binum"));
				bi.setBitable(rs.getString("bitable"));
				bi.setBitext(rs.getString("bitext"));
				bi.setBifile(rs.getString("bifile"));
				bi.setBicredat(rs.getString("bicredat"));
				bi.setBimodat(rs.getString("bimodat"));
				bi.setBicnt(rs.getInt("bicnt"));
				bi.setUinum(rs.getInt("uinum"));
				bi.setUiname(rs.getString("uiname"));
				biList.add(bi);
			}
			return biList;
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}
	private void close() {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public int updateBoardCnt(BoardInfoVo bi) throws SQLException {
		String sql = "update board_info set bicnt = bicnt+1 where binum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, bi.getBinum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}
	}

	@Override
	public int insertCommment(CommentInfoVo ci) throws SQLException {
		String sql = "insert into comment_info(citext, cicredat,cimodat,uinum, binum)";
		sql += "values(?,now(),now(),?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ci.getCitext());
			ps.setInt(2, ci.getUinum());
			ps.setInt(3, ci.getBinum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public CommentInfoVo selectComment(CommentInfoVo ci) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentInfoVo> selectCommentList(CommentInfoVo ci) throws SQLException {
		String sql = "select ci.*, ui.uiname from  comment_info ci, user_info ui\r\n" + 
				"where ci.uinum=ui.uinum and binum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ci.getBinum());
			rs = ps.executeQuery();
			List<CommentInfoVo> ciList = new ArrayList<CommentInfoVo>();
			while(rs.next()) {
				ci = new CommentInfoVo();
				ci.setCinum(rs.getInt("cinum"));
				ci.setBinum(rs.getInt("binum"));
				ci.setCicredat(rs.getString("cicredat"));
				ci.setCitext(rs.getString("citext"));
				ci.setUinum(rs.getInt("uinum"));
				ci.setUiname(rs.getString("uiname"));
				ciList.add(ci);
			}
			return ciList;
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public int deleteComment(CommentInfoVo ci) throws SQLException {
		String sql = "delete from comment_info where cinum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, ci.getCinum());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public int countBoardList() throws SQLException {
			String sql = "select count(*) from board_info bi,user_info ui"
					+ " where bi.uinum=ui.uinum";
			
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()) {
					return rs.getInt(1);
				}
			}catch(SQLException e) {
				throw e;
			}finally {
				close();
			}
			return 0;
		}
	}

	

