package xyz.vaith.servlet;

import xyz.vaith.controller.InputProductController;
import xyz.vaith.controller.SaveProductController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DispatcherServlet", urlPatterns = {"/product_input.action", "/product_save.action"})
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        int lastIndex= uri.lastIndexOf("/");
        uri = uri.substring(lastIndex+1);
        String disUrl = null;
        if (uri.equals("product_input.action")) {
            InputProductController controller = new InputProductController();
            disUrl = controller.handleRequest(request, response);
        } else if (uri.equals("product_save.action")) {
            SaveProductController controller = new SaveProductController();
            disUrl = controller.handleRequest(request, response);
        }
        if (disUrl != null) {
            request.getRequestDispatcher(disUrl).forward(request, response);
        }
    }
}
