package xyz.vaith.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class SelectElementTag extends SimpleTagSupport {
    private String[] countries = {"Austrialia", "Brazil", "China"};

    @Override
    public void doTag() throws JspException, IOException {
        JspContext context = getJspContext();
        JspWriter writer = context.getOut();
        writer.println("<select>\n");
        for (int i = 0; i < 3; i++) {
            context.setAttribute("value", countries[i]);
            context.setAttribute("text", countries[i]);
            getJspBody().invoke(null);
        }
        writer.println("</select>\n");
    }
}
