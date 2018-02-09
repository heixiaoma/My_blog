package hxm.servlet;

import hxm.article.ArtDao;
import hxm.article.articles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
public class Page extends HttpServlet {
    private int pages_size;
    private String type;
    private ArtDao pdo=new ArtDao();
    private boolean bool=true;
    private int count;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            count=pdo.get_count();
            pages_size=Integer.parseInt(new String( req.getParameter("page").getBytes("ISO8859-1"),"UTF-8"));
            type=new String( req.getParameter("type").getBytes("ISO8859-1"),"UTF-8");
            req.setCharacterEncoding("UTF-8");
            List<articles> list=null;
            if(type.equals("h")) {
                //防止下一页超标
                if(count/5<pages_size) {
                    pages_size = count / 5;
                }
                list= pdo.get_page_next(pages_size);
            }else if(type.equals("q")){
                //防止上一页超标
                if (pages_size==0) {
                    pages_size++;
                }
                list = pdo.get_page_next(pages_size-1);
            }
            System.out.println("pages:"+pages_size);
            if(type.equals("h")) {
                    pages_size++;
                    bool=true;
            }else if(type.equals("q")){
                    bool=false;
            }
            req.setAttribute("ren_list", list);
            req.setAttribute("pages_size",pages_size);
            req.getRequestDispatcher("web/index.jsp").forward(req, resp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
