package bookManager;

import bookManager.book.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface BM {
    public void addBook(HttpServletRequest req);
    public void addBook(String[] bookInfo,String[] checkOutInfo);
    public void sortBook(HttpServletRequest req);
    public List<Book> searchBook(HttpServletRequest req);
    public void editBook(HttpServletRequest req);
    public void removeBook(HttpServletRequest req);
    public void printBook(HttpServletRequest req,HttpServletResponse resp);
    public void checkOutBook(HttpServletRequest req);

    public void checkInBook(HttpServletRequest req);
    public Book getBook(String id);
}
