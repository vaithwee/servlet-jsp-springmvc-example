package xyz.vaith.controller;

import xyz.vaith.bean.Product;
import xyz.vaith.bean.ProductForm;
import xyz.vaith.xyz.vaith.validator.ProductValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveProductController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        ProductForm form = new ProductForm();
        form.setName(request.getParameter("name"));
        form.setDescription(request.getParameter("description"));
        form.setPrice(request.getParameter("price"));

        List<String> errors = ProductValidator.validate(form);

        if (errors.isEmpty()) {
            Product product = new Product();
            product.setName(form.getName());
            product.setDescription(form.getDescription());
            try {
                product.setPrice(Float.parseFloat(form.getPrice()));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            request.setAttribute("product", product);
            return "/WEB-INF/ProductDetail.jsp";
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("form", form);
            return "/WEB-INF/ProductForm.jsp";
        }


    }
}
