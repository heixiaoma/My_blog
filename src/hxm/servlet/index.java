package hxm.servlet;

import hxm.article.ArtDao;
import hxm.article.articles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class index extends HttpServlet
{
    //首页展示
    private ArtDao pdo=new ArtDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");
            System.out.println("index");
            List<articles> list= pdo.get_page_one();
            req.setAttribute("ren_list", list);
            req.setAttribute("pages_size",1);
            req.getRequestDispatcher("web/index.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
