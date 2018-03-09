package com.homework1.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CancelController",value = "/Cancel")
public class CancelController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession  session = request.getSession();
        //销毁整个session
        session.invalidate();
        ServletContext context = this.getServletContext();
        int count = (int)context.getAttribute("COUNT");
        count--;
        context.setAttribute("COUNT",count);
        response.sendRedirect(request.getContextPath()+"/MainView");
    }
}
