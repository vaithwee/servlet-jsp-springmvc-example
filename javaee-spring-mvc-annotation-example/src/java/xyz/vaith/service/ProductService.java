package xyz.vaith.service;

import xyz.vaith.bean.Product;

public interface ProductService {
    Product add(Product product);
    Product get(long id);
}
