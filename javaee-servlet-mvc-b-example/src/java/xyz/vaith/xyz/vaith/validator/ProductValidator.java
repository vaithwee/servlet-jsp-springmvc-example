package xyz.vaith.xyz.vaith.validator;

import xyz.vaith.bean.ProductForm;

import java.util.ArrayList;
import java.util.List;

public class ProductValidator {
    public static List<String> validate(ProductForm productForm) {
        List<String> errors = new ArrayList<String>();
        String name = productForm.getName();
        if (name == null || name.trim().isEmpty()) {
            errors.add("Product must have a name");
        }
        String price = productForm.getPrice();
        if (price == null || price.trim().isEmpty()) {
            errors.add("Product must have a price");
        } else {
            try {
                Float.parseFloat(price);
            } catch (NumberFormatException e) {
                errors.add("Invalid price value");
            }
        }
        return errors;
    }

}
