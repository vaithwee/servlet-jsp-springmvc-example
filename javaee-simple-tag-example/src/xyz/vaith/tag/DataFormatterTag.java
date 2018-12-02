package xyz.vaith.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.StringTokenizer;

public class DataFormatterTag extends SimpleTagSupport {
    private String header;
    private String items;
    public void setHeader(String header) {
        this.header = header;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspContext jspContext = getJspContext();
        JspWriter writer = jspContext.getOut();
        writer.println("<table style='border: 1px solid green;'><tr><td><span style='font-weight:bold'> "+ header +"</span></td></tr>");
        StringTokenizer tokenizer = new StringTokenizer(items, ",");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            writer.println("<tr><td>" + token + "</td></tr>");
        }
        writer.println("</table>");
    }
}
