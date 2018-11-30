package xyz.vaith.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletConfigDemoServlet", urlPatterns = {"/servletConfigDemo"}, initParams = {
        @WebInitParam(name = "admin", value = "Vaith Wee"),
        @WebInitParam(name = "email", value = "vaithwee@gmail.com")
})
public class ServletConfigDemoServlet implements Servlet {
    private transient ServletConfig servletConfig;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String admin = config.getInitParameter("admin");
        String email = config.getInitParameter("email");
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<html><head></head><body>"
                + "Admin: " + admin + "<br />E-mail: " + email +
                "</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "ServletConfig demo";
    }

    @Override
    public void destroy() {

    }
}
