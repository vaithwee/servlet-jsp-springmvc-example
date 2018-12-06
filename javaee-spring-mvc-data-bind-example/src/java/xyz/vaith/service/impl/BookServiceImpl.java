package xyz.vaith.service.impl;

import org.springframework.stereotype.Service;
import xyz.vaith.domain.Book;
import xyz.vaith.domain.Category;
import xyz.vaith.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private List<Category> categories;
    private List<Book> books;

    public BookServiceImpl() {
        categories = new ArrayList<Category>();
        categories.add(new Category(1, "Computing"));
        categories.add(new Category(2, "Travel"));
        categories.add(new Category(3, "Health"));

        books = new ArrayList<Book>();
        books.add(new Book(1L, "9780980839623", "Servlet & JSP: A Tutorial", categories.get(0),"Budi Kurniawan"));
        books.add(new Book(2L, "9780980839630", "C#: A Beginner's Tutorial", categories.get(0), "Jayden Ky"));
    }

    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public Category getCategory(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book save(Book book) {
        book.setId(getNextId());
        books.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        int bookCount = books.size();
        for (int i = 0; i < bookCount; ++i) {
            Book savedBook = books.get(i);
            if (savedBook.getId() == book.getId()) {
                books.set(i, book);
                return book;
            }
        }
        return book;
    }

    @Override
    public Book get(long id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    @Override
    public long getNextId() {
        long id = 0L;
        for (Book book : books) {
            long bookId = book.getId();
            if (bookId > id) {
                id = bookId;
            }
        }
        return id + 1;
    }
}
