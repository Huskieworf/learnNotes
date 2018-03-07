package com.manager.ui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reg
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//响应一个注册界面

		//通过响应头让浏览器跳转页面
//		response.setStatus(302);
//		response.setHeader("location", "http://www.baidu.com");
		
		//下载文件
		//附件的头  告诉浏览器有附件要下载
//		response.setHeader("Content-Disposition", "attachment;filename=book.sql");
//		//通过io流 传输文件
//		InputStream is = new FileInputStream("C:\\Users\\hchr\\Desktop\\book.sql");
//		byte [] bytes = new byte[1024];
//		int len = 0;
//		while((len = is.read(bytes)) != -1) {
//			response.getOutputStream().write(bytes, 0, len);
//		}
		
		String username = "";
		//接收客户端的cookie信息
		Cookie [] cookies = request.getCookies();
		//如果客户端没有发送cookie信息，那么 这个数组为null
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("username")) {
					username = cookie.getValue();
				}
			}
		}
		
		//设置响应的内容类型及编码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<form action='/userManager_01/loginDo' method='post'>");
		out.println("<span>账号</span><input type='text' name='username' value='"+username+"'><br/>");
		out.println("<span>密码</span><input type='password' name='password'><br/>");
		out.println("<input type='checkbox' name='isSave' value=\"save\"><span>记住账号</span><br/>");
		out.println("<input type='submit' value='登录'/><br/>");
		out.println("</form>");
		String uri = request.getRequestURI();
		String url = request.getRequestURL().toString();
		System.out.println(uri);
		System.out.println(url);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
