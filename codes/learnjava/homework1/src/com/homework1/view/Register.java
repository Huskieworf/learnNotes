package com.homework1.view;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应一个注册界面
        //设置响应的内容类型及编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<form action='/homework1/regDone' method='post'>");
        out.println("<span>账号</span><input type='text' name='username'><br/>");
        out.println("<span>密码</span><input type='password' name='password'><br/>");
        out.println("<span>性别</span><input type='radio' name='sex' value='男'>男<input type='radio' name='sex' value='woman'>女<br/>");
        out.println("<span>爱好</span><input type='text' name='likes'><br/>");
        out.println("<span>地址</span><select name='address'>"
                + "<option value='chengdu'>成都</option>"
                + "<option value='didu'>帝都</option>"
                + "<option value='modu'>魔都</option>"
                + "<option value='yaodu'>妖都</option>"
                + "<option value='wudu'>雾都</option>"
                + "<option value='xingdu'>性都</option>"
                + "</select><br/>");
        out.println("<span>个人介绍</span><textarea name='introduction'></textarea><br/>");
        out.println("<input type='submit' value='注册'/><br/>");
        out.println("</form>");
    }
}
