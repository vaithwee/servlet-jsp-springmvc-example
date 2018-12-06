package xyz.vaith.service;

import xyz.vaith.domain.Book;
import xyz.vaith.domain.Category;

import java.util.List;

public interface BookService {

    List<Category> getAllCategories();
    Category getCategory(int id);
    List<Book> getAllBooks();
    Book save(Book book);
    Book update(Book book);
    Book get(long id);
    long getNextId();
}
