package hxm.servlet;

import hxm.article.Pa;
import hxm.article.articles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class pa extends HttpServlet
{
    //首页展示
    private Pa pdo=new Pa();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            System.out.println("pa");
            List<articles> list= pdo.get_page_one();
            System.out.println("文章："+list);
            req.setAttribute("ren_list", list);
            req.setAttribute("pages_size",1);
            req.getRequestDispatcher("web/pa.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
