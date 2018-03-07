package com.manager.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manager.dao.UserDao;
import com.manager.entity.User;

/**
 * Servlet implementation class RegController
 */
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao userDao  = new UserDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String introduce = request.getParameter("introduce");
		String [] hobbys = request.getParameterValues("hobby");
		String id = request.getParameter("uid");
		int uid = Integer.parseInt(id);
		// 非空判断
		if(username == null || "".equals(username)) {
			response.getWriter().println("账号为空无法注册");
			return;
		}
		
		User user = new User(uid, username, password, sex, address, introduce, hobbys);
		boolean isSuccess = userDao.update(user);
		response.sendRedirect(request.getContextPath()+"/main");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
