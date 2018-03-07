package com.homework1.controller;

import com.homework1.dao.UserDao;
import com.homework1.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regDone")
public class RegisterController extends HttpServlet {
    UserDao userDao  = new UserDao();
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String likes = request.getParameter("likes");
        String address = request.getParameter("address");
        String introduction =request.getParameter("introduction");
        if(username == null || "".equals(username)) {
                response.getWriter().println("账号为空无法注册");
                return;
        }
        User user = new User(0, username, password, sex,likes,address,introduction);
        boolean isSuccessful = userDao.register(user);
        if (isSuccessful) {
            response.sendRedirect("/homework1/login");
        }else {
            response.sendRedirect("/homework1/register");
        }

    }
}
