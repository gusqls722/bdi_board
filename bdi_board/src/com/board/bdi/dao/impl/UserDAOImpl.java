package com.board.bdi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.board.bdi.dao.UserDAO;
import com.board.bdi.vo.UserInfoVo;

public class UserDAOImpl implements UserDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void setCon(Connection con) {
		this.con=con;
	}

	@Override
	public int insertUser(UserInfoVo ui) throws SQLException {
		String sql = "insert into user_info(uiId, uiname, uipwd, uiemail)";
		sql += " values(?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUiid());
			ps.setString(2, ui.getUiname());
			ps.setString(3, ui.getUipwd());
			ps.setString(4, ui.getUiemail());
			return ps.executeUpdate();
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
	}

	@Override
	public UserInfoVo selectUser(UserInfoVo ui) throws SQLException {
		String sql = "select * from user_info";
		sql += " where uiId=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, ui.getUiid());
			rs = ps.executeQuery();
			if(rs.next()) {
				ui = new UserInfoVo();
				ui.setUiid(rs.getString("uiId"));
				ui.setUinum(rs.getInt("uiNum"));
				ui.setUiemail(rs.getString("uiEmail"));
				ui.setUiname(rs.getString("uiName"));
				ui.setUipwd(rs.getString("uiPwd"));
				return ui;
			}
		}catch(SQLException e) {
			throw e;
		}finally {
			close();
		}
		return null;
	}
	
	private void close() {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(ps!=null) {
				ps.close();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
