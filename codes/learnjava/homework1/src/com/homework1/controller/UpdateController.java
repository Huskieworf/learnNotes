package com.homework1.controller;

import com.homework1.dao.UserDao;
import com.homework1.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateController", value = "/UpdateDone")
public class UpdateController extends HttpServlet {
    UserDao userDao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex = request.getParameter("sex");
        String address = request.getParameter("address");
        String introduction = request.getParameter("introduction");
        String likes = request.getParameter("likes");
        String id = request.getParameter("uid");
        int uid = Integer.parseInt(id);
        // 非空判断
        if(username == null || "".equals(username)||password == null || "".equals(password)) {
            response.getWriter().println("账号密码不能为空");
            return;
        }

        User user = new User(uid, username, password, sex,likes, address, introduction);
        boolean isSuccess = userDao.update(user);
        response.sendRedirect(request.getContextPath()+"/MainView");

    }
}
