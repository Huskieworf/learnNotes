package com.homework1.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Update", value = "/update")
public class Update extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        out.println("<form action='/homework1/UpdateDone' method='post'>");
        out.println("<input type='hidden' name='uid' value='"+request.getParameter("uid")+"'><br/>");
        out.println("<span>账号</span><input type='text' name='username'><br/>");
        out.println("<span>密码</span><input type='password' name='password'><br/>");
        out.println("<span>性别</span><input type='radio' name='sex' value='男'>男<input type='radio' name='sex' value='woman'>女<br/>");
        out.println("<span>爱好</span><input type='text' name='likes'><br/>");
        out.println("<span>地址</span><select name='address'>"
                + "<option value='成都'>成都</option>"
                + "<option value='北京'>帝都</option>"
                + "<option value='上海'>魔都</option>"
                + "<option value='广州'>妖都</option>"
                + "<option value='重庆'>雾都</option>"
                + "<option value='东莞'>性都</option>"
                + "</select><br/>");
        out.println("<span>个人介绍</span><textarea name='introduction'></textarea><br/>");
        out.println("<input type='submit' value='修改'/><br/>");
        out.println("</form>");
    }
}
