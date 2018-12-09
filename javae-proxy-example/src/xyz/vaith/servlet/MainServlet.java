package xyz.vaith.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet(name = "MainServlet", urlPatterns = {"/mail"})
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        String password = request.getParameter("password");
        String to = request.getParameter("to");
        String object = request.getParameter("object");
        String c = request.getParameter("content");

        StringBuilder content = new StringBuilder();

        content.append("<body>");
        content.append("<span style=\"font-size:15px\">Hi. This is the New Grade·Inform.</span>");
        content.append("<hr>");
        //简单版本
        /*String text;
        for (Grade grade:arrayList) {
            text = "";
            text += grade.toString();
            content.append(text);
            content.append("<br>");
        }*/
        //表格版本
        content.append("<table>");
        content.append("<thead>");
        content.append("<tr>");
        content.append("<th>课程名</th>");
        content.append("<th>分数</th>");
        content.append("<th>绩点</th>");
        content.append("<th>学分</th>");
        content.append("<th>属性</th>");
        content.append("</tr>");
        content.append("</thead>");
        content.append("<tbody>");
        for (int i = 0; i < 10; ++i) {
            content.append("<tr>");
            content.append("<td style=\"text-align:center\">"+to+"</td>");
            content.append("<td>"+i+"</td>");
            content.append("<td>"+i+"</td>");
            content.append("<td>"+i+"</td>");
            content.append("<td>"+i+"</td>");
            content.append("</tr>");
        }
        content.append("</tbody>");
        content.append("</table>");

        content.append("<hr>");
        content.append("<span style=\"font-size:17px\">Thank you! </span></body>");

        // 0.1 服务器的设置
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");
        // 0.2 账号和密码
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 126账号和密码（模拟账号，需要自己注册）
                //return new PasswordAuthentication("itcast", "123456");
                return new PasswordAuthentication(from, password);
            }
        };

        // 1 与126服务器建立连接：Session
        Session session = Session.getDefaultInstance(props, authenticator);

        // 2 编写邮件：Message
        Message message = new MimeMessage(session);
        // 2.1 发件人（模拟账号）
        //message.setFrom(new InternetAddress("itcast@126.com"));
        try {
            message.setFrom(new InternetAddress(from + "@163.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // 2.2 收件人 , to:收件人 ， cc ：抄送，bcc：暗送（密送）。（模拟账号）
        try {
            message.setRecipient(RecipientType.TO, new InternetAddress(to));
            message.setRecipient(RecipientType.CC, new InternetAddress(from+"@163.com"));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // 2.3 主题
        try {
            message.setSubject(object);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        // 2.4 内容
        try {
            message.setContent(content.toString(), "text/html;charset=UTF-8");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        // 3 将消息进行发送：Transport
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        response.getWriter().println("success");
    }
}
