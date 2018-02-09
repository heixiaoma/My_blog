package hxm.servlet;

import hxm.article.Cj;
import hxm.article.Pa_in;
import hxm.config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class Pa_cj extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type=null;
        String status=null;
        try {
             type = new String(req.getParameter("type").getBytes("gbk"), "UTF-8");
             status = new String(req.getParameter("status").getBytes("gbk"), "UTF-8");
        }catch (Exception r){

        }
            switch (type){
                case "sd":
                    //手动
                    Pa_in.sd();
                    break;
                case "auto":
                    if (status.equals("yes")){
                        //开启
                        hxm.config.task_status=true;
                        System.out.println("自动开");
                    }else {
                        //关闭
                        hxm.config.task_status=false;
                        System.out.println("自动关");
                    }
                    break;
            }


        System.out.println("被访问");
        req.getRequestDispatcher("../admin/pa_m.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
