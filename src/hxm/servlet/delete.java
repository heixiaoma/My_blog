package hxm.servlet;

import hxm.article.ArtDao;
import hxm.article.articles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class delete extends HttpServlet {

    private ArtDao pdo=new ArtDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        try{
        String id=new String( req.getParameter("id").getBytes("ISO8859-1"),"UTF-8");
        if(!id.equals("")) {
            pdo.delete(id);
        }}catch (Exception e){}
        List<articles> list = pdo.get_All();
        req.setAttribute("ren_list", list);
        req.getRequestDispatcher("table.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
