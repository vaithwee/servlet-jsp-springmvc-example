package xyz.vaith.vaith;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "GenericServletDemo", urlPatterns = {"/generic"}, initParams = { @WebInitParam(name = "admin", value = "Vaith Wee"), @WebInitParam(name = "email", value = "vaithwee@gmail.com")})
public class GenericServletDemoServlet extends GenericServlet {
    private static final long serialVersionUID = 62500890L;
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String admin = config.getInitParameter("admin");
        String email = config.getInitParameter("email");
        servletResponse.setContentType("text/html;charset=utf-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.print("<html><head></head><body>Admin:" + admin+ "<br />Email:" + email +"</body></html>");
    }
}
