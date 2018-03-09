package com.homework1.controller;

import com.homework1.dao.UserDao;
import com.homework1.domain.User;

import javax.jms.Session;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginDone")
public class LoginController extends HttpServlet {
    UserDao userDao = new UserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.getServletContext().setAttribute("COUNT", 0);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String save = request.getParameter("savePW");
        Object o = session.getAttribute("CUR_USER");
        if(o!=null){
            response.sendRedirect(request.getContextPath() + "/MainView");
            return;
        }
        if ("save".equals(save)) {
            //1.创建cookie对象
            Cookie cookie = new Cookie("cur_user", username);
            //2.设置cookie的生命周期
            //cookie.setMaxAge(60*60);
            //3.设置cookie访问路径
            cookie.setPath("/homework1/login");
            //4.响应到客户端
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("cur_user", "");
            //设置cookie的生命周期
            cookie.setMaxAge(0);
            cookie.setHttpOnly(true);
            cookie.setPath("/homework1/login");
            response.addCookie(cookie);
        }
        PrintWriter out = response.getWriter();
        // 非空判断
        if (username == null || "".equals(username)) {
            out.println("账号为空无法登陆");
            return;
        }

        User user = userDao.login(username, password);
        if (user != null) {
            //获取Session
//            HttpSession session = request.getSession();
            //将Cookie放入Session中
            Cookie cookie = new Cookie("JSESSIONID", session.getId());
            cookie.setMaxAge(30 * 60);
            response.addCookie(cookie);
            //将一个对象放入session中
            session.setAttribute("CUR_USER", user);


            ServletContext context = this.getServletContext();
            if (context != null) {
                int count = (int) context.getAttribute("COUNT");
                count++;
                context.setAttribute("COUNT", count);
            } else {
                context.setAttribute("COUNT", 1);
            }

            response.sendRedirect(request.getContextPath() + "/MainView");
        } else {
            out.println("账号或密码错误");
            out.println("<a href='/homework1/login'>返回登陆</a>");
        }
    }
}
