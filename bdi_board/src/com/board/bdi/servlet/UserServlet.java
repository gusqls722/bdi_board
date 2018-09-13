package com.board.bdi.servlet;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.bdi.common.ParseUtil;
import com.board.bdi.service.UserService;
import com.board.bdi.service.impl.UserServiceImpl;
import com.board.bdi.vo.UserInfoVo;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String uri;
    private UserService us = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
			if(cmd.equals("Logout")) {
				us.logoutUser(request);
				uri = "/views/user/userLogin";
			}
		}catch(SQLException e) {
			throw new ServletException("에러 : " + e.getMessage());
		}
		doService(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = "/views" + request.getRequestURI();
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		try {
			if(cmd.equals("userJoin")) {
				us.joinUser(request);
			}else if(cmd.equals("userLogin")) {
				us.loginUser(request);
			}
		}catch(SQLException e) {
			throw new ServletException("에러 : " + e.getMessage());
		}
		doService(request, response);
	}
	private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(uri);
		rd.forward(request, response);
	}

}
