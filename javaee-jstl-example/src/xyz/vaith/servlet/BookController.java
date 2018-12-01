package xyz.vaith.servlet;

import xyz.vaith.bean.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/books"})
public class BookController extends HttpServlet {
    private static final int serialVersionUID = -234237;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("978-0980839616", "Java 7: A Beginner's Tutorial", 45.00));
        books.add(new Book("978-0980331608", "Strus 2 Design and Programming: A Tutorial", 49.95));
        books.add(new Book("978-0975212920", "Dimensional Data Warehousing with MySQL: A Tutorial", 39.95));
        req.setAttribute("books", books);
        req.getRequestDispatcher("/books.jsp").forward(req, resp);
    }
}
