package com.homework1.view;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login")
public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //设置响应的内容类型及编码
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username="";
        //接受客户端的cookie信息
        Cookie[] cookies = request.getCookies();
        //如果客户端没有发送Cookie信息，那么cookies=null
        if(cookies!=null){
            for (Cookie cookie:cookies) {
                if(cookie.getName().equals("cur_user")){
                    username=cookie.getValue();
                }
            }
        }
        out.println("<form action='/homework1/loginDone' method='post'>");
        out.println("<span>账号</span><input type='text' name='username' value='"+username+"'><br/>");
        out.println("<span>密码</span><input type='password' name='password'><br/>");
        out.println("<span>记住密码<span><input type='checkbox' name='savePW' checked='checked' value='save'><br/>");
        out.println("<input type='submit' value='登录'/><br/>");
        out.println("</form>");
    }
}
