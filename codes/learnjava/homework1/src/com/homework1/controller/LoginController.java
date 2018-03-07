package com.homework1.controller;

import com.homework1.dao.UserDao;
import com.homework1.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginDone")
public class LoginController extends HttpServlet {
        UserDao userDao=new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String save = request.getParameter("savePW");
        if("save".equals(save)){
            //1.创建cookie对象
            Cookie cookie = new Cookie("cur_user",username);
            //
            response.addCookie(cookie);
        }
        PrintWriter out = response.getWriter();
        // 非空判断
        if(username == null || "".equals(username)) {
            out.println("账号为空无法登陆");
            return;
        }

        User user = userDao.login(username,password);
        if(user != null) {
            response.sendRedirect(request.getContextPath()+"/MainView?username="+username);
        }else {
            out.println("账号或密码错误");
            out.println("<a href='/homework1/login'>返回登陆</a>");
        }
    }
}
