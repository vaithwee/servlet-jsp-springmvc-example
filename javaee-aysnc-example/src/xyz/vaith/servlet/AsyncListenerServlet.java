package xyz.vaith.servlet;

import xyz.vaith.listener.MyAsyncListener;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "asyncListenerServlet", urlPatterns = {"/asyncListener"}, asyncSupported = true)
public class AsyncListenerServlet extends HttpServlet {
    private static final long serialVersionUID = 62738L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(5000);
        asyncContext.addListener(new MyAsyncListener());
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String greeting = "hi from listener";
                System.out.println("waiting");
                req.setAttribute("greeting", greeting);
                asyncContext.dispatch("/test.jsp");
            }
        });
    }
}
