package bookManager;

import bookManager.book.Book;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BM {
    public void addBook(HttpServletRequest req) throws Exception;
    public void addBook(String[] bookInfo,String[] checkOutInfo) throws Exception;
    public void sortBook(HttpServletRequest req) throws Exception;
    public List<Book> searchBook(HttpServletRequest req) throws Exception;
    public void editBook(HttpServletRequest req) throws Exception;
    public void removeBook(HttpServletRequest req) throws Exception;
    public String printBook(HttpServletRequest req);
    public void checkOutBook(HttpServletRequest req) throws Exception;

    public void checkInBook(HttpServletRequest req) throws Exception;
    public Book getBook(String id);
}
