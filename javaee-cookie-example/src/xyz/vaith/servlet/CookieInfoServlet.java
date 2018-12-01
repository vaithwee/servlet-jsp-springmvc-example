package xyz.vaith.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieInfoServlet", urlPatterns = {"/cookieInfo"})
public class CookieInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 3829L;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        StringBuffer style = new StringBuffer();
        style.append(".title {");
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                if ("titleFontSize".equals(name)) {
                    style.append("font-size:" + value + ";");
                } else if ("titleFontWeight".equals(name)) {
                    style.append("font-weight:" + value + ";");
                } else if ("titleFontStyle".equals(name)) {
                    style.append("font-style:" + value + ";");
                }
            }
        }
        style.append("}");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Cookie Info</title><style>"+ style.toString()+"</style></head><body>"+PreferenceServlet.MENU+"<div class='title'>Session Management with Cookies:</div><div>");
        if (cookies == null) {
            writer.println("No cookie in this HTTP response");
        } else  {
            for (Cookie cookie : cookies) {
                writer.println("<br/>" + cookie.getName() + ":" + cookie.getValue());
            }
        }
       writer.println("</div></body></html>");
    }
}
