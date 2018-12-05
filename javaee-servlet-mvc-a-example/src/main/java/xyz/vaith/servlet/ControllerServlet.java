package xyz.vaith.servlet;

import xyz.vaith.bean.Product;
import xyz.vaith.bean.ProductForm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ControllerServlet", urlPatterns = {"/product_input.action", "/product_save.action"})
public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex+1);
        if (action.equals("product_input.action")) {

        } else if (action.equals("product_save.action")) {
            ProductForm form = new ProductForm();
            form.setName(request.getParameter("name"));
            form.setDescription(request.getParameter("description"));
            form.setPrice(request.getParameter("price"));

            Product product = new Product();
            product.setName(form.getName());
            product.setDescription(form.getDescription());
            try {
                product.setPrice(Float.parseFloat(form.getPrice()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            request.setAttribute("product", product);
        }

        String disUrl = null;
        if (action.equals("product_input.action")) {
            disUrl = "/WEB-INF/ProductForm.jsp";
        } else if (action.equals("product_save.action")) {
            disUrl = "/WEB-INF/ProductDetail.jsp";
        }
        request.getRequestDispatcher(disUrl).forward(request, response);

    }
}
