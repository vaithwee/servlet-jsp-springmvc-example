package xyz.vaith.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import xyz.vaith.bean.Product;
import xyz.vaith.bean.ProductForm;

public class SaveProductController implements Controller {
    private static final Log logger = LogFactory.getLog(SaveProductController.class);
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        logger.info("SaveProductController called");
        ProductForm form = new ProductForm();
        form.setPrice(httpServletRequest.getParameter("price"));
        form.setName(httpServletRequest.getParameter("name"));
        form.setDescription("description");

        Product product = new Product();
        product.setName(form.getName());
        product.setDescription(form.getDescription());
        try {
            product.setPrice(Float.parseFloat(form.getPrice()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return new ModelAndView("ProductDetail", "product", product);
    }
}
