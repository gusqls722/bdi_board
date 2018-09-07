package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.board.bdi.common.DBConnection;
import com.board.bdi.dao.UserDAO;
import com.board.bdi.dao.impl.UserDAOImpl;
import com.board.bdi.vo.UserInfoVo;

class UserDAOTest {

	@Test
	void selectUserTest() {
		UserDAO udao = new UserDAOImpl();
		udao.setCon(DBConnection.getCon());
		try {
			UserInfoVo ui = new UserInfoVo();
			UserInfoVo rUi = udao.selectUser(ui);
			assertEquals(rUi, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void insertUserTest() {
		UserDAO udao = new UserDAOImpl();
		udao.setCon(DBConnection.getCon());
		try {
			UserInfoVo ui = new UserInfoVo();
			ui.setUiid("test");
			ui.setUiname("홍길동");
			ui.setUipwd("r1r2r3");
			ui.setUiemail("test@naver.com");
			int cnt = udao.insertUser(ui);
			DBConnection.commit();
			assertEquals(cnt, 0);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close();
		}
	}
}
