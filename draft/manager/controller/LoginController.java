package com.manager.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.dao.UserDao;
import com.manager.entity.User;

/**
 * Servlet implementation class RegController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao userDao  = new UserDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String isSave = request.getParameter("isSave");
		//使用cookie记录账号
		if("save".equals(isSave)) {
			//1 创建cookie对象
			Cookie cookie = new Cookie("username", username);
			//设置cookie的生命周期
			cookie.setMaxAge(60*60);
			//设置cookie的访问路径
			cookie.setPath("/userManager_01/login");
			//2响应到客户端
			response.addCookie(cookie);
		}else {
			Cookie cookie = new Cookie("username", "");
			//设置cookie的生命周期
			cookie.setMaxAge(0);
			cookie.setHttpOnly(true);
			cookie.setPath("/userManager_01/login");
			response.addCookie(cookie);
		}
		// 非空判断
		if(username == null || "".equals(username)) {
			response.getWriter().println("账号为空无法注册");
			return;
		}
		
		User user = userDao.login(username,password);
		if(user != null) {
			//获取到session
			HttpSession session = request.getSession();
			
			Cookie cookie = new Cookie("JSESSIONID", session.getId());
			cookie.setMaxAge(30*60);
			response.addCookie(cookie);
			session.setAttribute("CUR_USER", user);//将一个对象放入session
			response.sendRedirect(request.getContextPath()+"/main");
		}else {
			response.sendRedirect(request.getContextPath()+"/login");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
