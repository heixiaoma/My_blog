package hxm.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class adminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpResponse=(HttpServletResponse)servletResponse;
        HttpSession session=httpRequest.getSession();
        if(session.getAttribute("data")!=null){
            System.out.println("ok");
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            System.out.println("no ok");
            httpResponse.sendRedirect(httpRequest.getContextPath()+"../admin/login.html");
        }
    }

}
