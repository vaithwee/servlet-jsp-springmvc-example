package xyz.vaith.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PreferenceServlet", urlPatterns = {"/preference"})
public class PreferenceServlet extends HttpServlet {
    private static final long serialVersionUID = 888L;
    public static final String MENU = "<div style='background:#e8e8e8;padding:15px'>" +
            "<a href='cookieClass'>Cookie Class</a>&nbsp;&nbsp;" +
            "<a href='cookieInfo'>Cookie Info</a>&nbsp;&nbsp;" +
            "<a href='preference'>Preference</a></div>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Preference</title><style>table {background:NavajoWhite;font-size:small}</style></head><body>" + MENU +"Please select the values below: <form method='post'><table>"
                +"<tr><td>Title Font Size:</td>"
                +"<td><select name='titleFontSize'><option>large</option><option>x-large</option><option>xx-large</option></select></td>"
                +"</tr>"
                +"<tr><td>Title Style & Weight:</td>"
                +"<td><select name='titleStyleAndWeight' multiple><option>italic</option><option>bold</option></select></td></tr>"
                +"<tr><td>Max. Records in Table:</td><td><select name='maxRecords'><option>5</option><option>10</option></select></td></tr>"
                +"<tr><td rowspan='2'><input type='submit' value='Set' /></td></tr>"
                +"</table></form></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maxRecords = req.getParameter("maxRecords");
        String[] titleStyleAndWeight = req.getParameterValues("titleStyleAndWeight");
        String fontSize = req.getParameter("titleFontSize");
        resp.addCookie(new Cookie("maxRecords", maxRecords));
        resp.addCookie(new Cookie("titleFontSize", fontSize));

        Cookie cookie = new Cookie("titleFontWeight", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        cookie = new Cookie("titleFontStyle", "");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);

        if (titleStyleAndWeight != null) {
            for (String style : titleStyleAndWeight) {
                if ("bold".equals(style)) {
                    resp.addCookie(new Cookie("titleFontWeight", "bold"));
                } else if ("italic".equals(style)) {
                    resp.addCookie(new Cookie("titleFontStyle", "italic"));
                }
            }
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Preference</title></head><body>"
                + MENU
                +"Your preference has been set"
                +"<br /><br />Max. Records in Table:"
                +maxRecords
                +"<br />Title Font Size:" + fontSize
                +"<br />Title Font Style & Weight:");
        if (titleStyleAndWeight != null) {
            writer.println("<ul>");
            for (String style : titleStyleAndWeight) {
                writer.println("<li>" + style + "</li>");
            }
            writer.println("</ul>");
        }
        writer.println("</body></html>");
    }
}
