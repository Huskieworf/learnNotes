package com.manager.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reg
 */
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//响应一个注册界面
		//设置响应的内容类型及编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<form action='/userManager_01/regDo' method='post'>");
		out.println("<span>账号</span><input type='text' name='username'><br/>");
		out.println("<span>密码</span><input type='password' name='password'><br/>");
		out.println("<span>性别</span><input type='radio' name='sex' value='man'>男<input type='radio' name='sex' value='woman'>女<br/>");
		out.println("<span>爱好</span><input type='checkbox' name='hobby' value='basketball'>篮球<input type='checkbox' name='hobby' value='football'>足球<input type='checkbox' name='hobby' value='pingpang'>乒乓球<br/>");
		out.println("<span>地址</span><select name='address'>"
				+ "<option value='chengdu'>成都</option>"
				+ "<option value='didu'>帝都</option>"
				+ "<option value='modu'>魔都</option>"
				+ "<option value='yaodu'>妖都</option>"
				+ "<option value='wudu'>雾都</option>"
				+ "<option value='xingdu'>性都</option>"
				+ "</select><br/>");
		out.println("<span>个人介绍</span><textarea name='introduce'></textarea><br/>");
		out.println("<input type='submit' value='注册'/><br/>");
		out.println("</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
