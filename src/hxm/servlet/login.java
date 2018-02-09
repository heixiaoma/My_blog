package hxm.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("username").equals("admin")&&req.getParameter("pwd").equals("root")){
            //使用request对象的getSession()获取session，如果session不存在则创建一个
            HttpSession session = req.getSession();
            //将数据存储到session中
            session.setAttribute("data", "admin");
            req.getSession().setMaxInactiveInterval(1800);/*秒为单位，1800= 60*30 即30分种*/
            req.getRequestDispatcher("../admin/index.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("../admin/login.html").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
