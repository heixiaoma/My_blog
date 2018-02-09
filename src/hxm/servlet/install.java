package hxm.servlet;

import hxm.article.ArtDao;
import hxm.config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class install extends HttpServlet {
    private ArtDao pdo=new ArtDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
         pdo.install(hxm.config.sql1);
         pdo.install(hxm.config.sql2);
         pdo.install(hxm.config.sql3);
         pdo.install(hxm.config.sql4);
         pdo.install(hxm.config.sql5);
        }catch (Exception r){
            System.out.println("erro");
        }
        req.getRequestDispatcher("admin/index.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

}
