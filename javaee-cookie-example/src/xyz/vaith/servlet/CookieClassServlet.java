package xyz.vaith.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CookieClassServlet", urlPatterns = {"/cookieClass"})
public class CookieClassServlet extends HttpServlet {
    private static final long serialVersionUID = 837369L;
    private String[] methods = {"clone", "getComment", "getDomain", "getMaxAge", "getName", "getPath", "getSecure", "getValue", "getVersion", "isHttpOnly", "setComment", "setDomain", "setHttpOnly", "setMaxAge", "setPath", "setSecure", "setValue", "setVersion"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie maxRecordCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("maxRecords")) {
                    maxRecordCookie = cookie;
                    break;
                }
            }
        }

        int maxRecords = 5;
        if (maxRecordCookie != null) {
            try {
                maxRecords = Integer.parseInt(maxRecordCookie.getValue());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Cookie Class</title></head><body>"
                +PreferenceServlet.MENU
                +"<div>Here ara some of the methods in javax.servlet.http.Cookie</div>");
        writer.println("<ul>");
        for (int i = 0; i < maxRecords; i++) {
            writer.println("<li>"+methods[i]+"</li>");
        }
        writer.println("</ul>");
        writer.println("</body></html>");
    }
}
