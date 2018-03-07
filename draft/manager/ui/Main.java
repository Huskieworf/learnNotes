package com.manager.ui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.manager.dao.UserDao;
import com.manager.entity.User;

/**
 * Servlet implementation class Main
 */
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserDao userDao = new UserDao();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();//如果之前获取过session就返回之前获取的 之前没有获取或者已经被销毁了 就返回新的session
		//
		session.setMaxInactiveInterval(3);
		Object o = session.getAttribute("CUR_USER");//设置生命周期
		PrintWriter out = response.getWriter();
		if(o != null) {
			User u = (User) o;
			List<User> users = userDao.selectAll();
			out.println("<span>欢迎你："+u.getUsername()+"</span><br/>");
			out.println("<a href='/userManager_01/cancel'>退出</a><br/>");
			out.println("<table border='1' cellspacing='0'>");
			out.println("<tr>");
			out.println("<td>ID</td>");
			out.println("<td>用户名</td>");
			out.println("<td>密码</td>");
			out.println("<td>性别</td>");
			out.println("<td>爱好</td>");
			out.println("<td>地址</td>");
			out.println("<td>介绍</td>");
			out.println("<td>操作</td>");
			out.println("</tr>");
			for (User user : users) {
				out.println("<tr>");
				out.println("<td>"+user.getUid()+"</td>");
				out.println("<td>"+user.getUsername()+"</td>");
				out.println("<td>"+user.getPassword()+"</td>");
				out.println("<td>"+user.getSex()+"</td>");
				out.println("<td>"+Arrays.toString(user.getHobbys())+"</td>");
				out.println("<td>"+user.getAddress()+"</td>");
				out.println("<td>"+user.getIntroduce()+"</td>");
				out.println("<td><a href='/userManager_01/update?uid="+user.getUid()+"'>修改</a>/<a href='/userManager_01/delete?uid="+user.getUid()+"'>删除</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
		}else {
			out.println("<a href='/userManager_01/login'>登录</a>/<a href='/userManager_01/reg'>注册</a>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
