package com.homework1.view;

import com.homework1.dao.UserDao;
import com.homework1.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet("/MainView")
public class MainView extends HttpServlet {
    UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<User> users = userDao.selectAll();
        String username = request.getParameter("username");
        if (username != null) {
            out.println("<h4>欢迎您"+username+"<h4>");
        }
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
            out.println("<td>" + user.getUid() + "</td>");
            out.println("<td>" + user.getUsername() + "</td>");
            out.println("<td>" + user.getPassword() + "</td>");
            out.println("<td>" + user.getSex() + "</td>");
            out.println("<td>" + user.getLikes() + "</td>");
            out.println("<td>" + user.getAddress() + "</td>");
            out.println("<td>" + user.getIntroduction() + "</td>");
            out.println("<td><a href='/homework1/update?uid=" + user.getUid() + "'>修改</a>/<a href='/homework1/Delete?uid=" + user.getUid() + "'>删除</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");

    }
}
