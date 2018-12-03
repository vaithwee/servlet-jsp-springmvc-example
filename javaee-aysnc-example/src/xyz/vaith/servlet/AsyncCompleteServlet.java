package xyz.vaith.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AsyncCompleteServlet extends HttpServlet {
    private static final long serialVersionUID = 78234L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        final PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>Async Servlet</title></head>");
        writer.println("<body><div id='progress'></div>");
        final AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(60000);
        asyncContext.start(new Runnable() {
            @Override
            public void run() {
                System.out.println("new thread:" + Thread.currentThread().getName());
                for (int i =0; i< 10; i++) {
                    writer.println("<script>");
                    writer.println("document.getElementById('progress').innerHTML = '" + i * 10 + "% complete'");
                    writer.println("</script>");
                    writer.flush();

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                /*
                * 下面的代码还是在循环结束后执行,但是因为浏览器的补全机制,所以显示完整
                * */
                writer.println("<script>");
                writer.println("document.getElementById('progress').innerHTML = 'DONE'");
                writer.println("</script>");
                writer.println("</body></html>");
                asyncContext.complete();
            }
        });
    }
}
