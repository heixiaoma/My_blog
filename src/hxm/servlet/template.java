package hxm.servlet;

import hxm.article.ArtDao;
import hxm.article.articles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class template extends HttpServlet {
    //文章详细的servlet
    private ArtDao pdo=new ArtDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String id=new String( req.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
      articles ar=pdo.get_one(id);
      req.setAttribute("ar",ar);
      req.getRequestDispatcher("web/look.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
