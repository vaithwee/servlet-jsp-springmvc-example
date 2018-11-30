package xyz.vaith.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", urlPatterns = {"/my"})
public class MyServlet implements Servlet {
    private transient ServletConfig config;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String servletName = config.getServletName();
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<html><head></head>"
                + "<body> Hello from " + servletName +
                "</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "My Servlet";
    }

    @Override
    public void destroy() {

    }
}
