package hxm.servlet;

import hxm.mail.Mail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class mail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content=new String( req.getParameter("content").getBytes("ISO8859-1"),"UTF-8");
        System.out.println(content);
        boolean b=new Mail().send(content);
        if(b){
            System.out.println("发送成功");
        }else {

            System.out.println("发送失败");
        }
        req.getRequestDispatcher("web/gbook.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
