package com.homework1.view;

import com.homework1.dao.UserDao;
import com.homework1.domain.Page;
import com.homework1.domain.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        String toPage = request.getParameter("toPage");
        PrintWriter out = response.getWriter();
        String pageNow = null;
        if (toPage!=null){
            if(toPage.matches("^[0-9]\\d*$")){
                pageNow = toPage;
            }
            else {
                out.println("输入有误，跳转失败，回到第一页");
            }
        }else {
            pageNow = request.getParameter("pageNow");
        }

        if (pageNow == null || "".equals(pageNow)) {
            pageNow = "1";
        }
        Page<User> page = new Page<>();
        page.setPageNow(Integer.parseInt(pageNow));
        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(10);
        Object o = session.getAttribute("CUR_USER");

//        List<User> users = userDao.selectAll();

        ServletContext context = this.getServletContext();

//        String username = request.getParameter("username");
        if (o != null) {
            page = userDao.selectAll(page);
            int count = (int) (context.getAttribute("COUNT"));
            out.println("<h5>COONT=" + count + "<h5>");
            User u = (User) o;
            out.println("<h4>当前浏览器登陆账号 <h4>");
            out.println("<h4>欢迎您" + u.getUsername() + "<h4>");
            out.println("<a href='/homework1/Cancel'>退出</a><br/>");
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
            for (User user : page.getList()) {
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
            if (page.getPageNow() > 1) {
                out.println("<a href='/homework1/MainView?pageNow="+(page.getPageNow()-1)+"'>上一页</a>");
            }
            //显示页码
            for (int i = 1; i <= page.getTotalPages(); i++) {
                if(i == page.getPageNow()) {
                    out.println("<a>"+i+"</a>");
                }else {
                    out.println("<a href='/homework1/MainView?pageNow="+i+"'>"+i+"</a>");
                }
            }
            if (page.getPageNow() < page.getTotalPages()) {
                out.println("<a href='/homework1/MainView?pageNow="+(page.getPageNow()+1)+"'>下一页</a>");
            }
            out.println("<form action='/homework1/MainView' method='post'>");
            out.println("<input type='text' name='toPage'>");
            out.println("<input type='submit' value='跳转'/><br/>");
            out.println("</form>");

        } else {
            out.println("<a href='/homework1/login'>登录</a>/<a href='/homework1/register'>注册</a>");
        }

    }
}
