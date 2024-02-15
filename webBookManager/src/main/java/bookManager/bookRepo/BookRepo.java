package bookManager.bookRepo;

import bookManager.book.Book;

import java.util.List;


public interface BookRepo {
    public List<Book> getBookList();
    public void addBook(Book book);
    public Book getBook(String id);
    public void removeBook(String id);
    public void sortBookList(String type,boolean asc);
    public List<Book> searchBook(String type, String search);
}
