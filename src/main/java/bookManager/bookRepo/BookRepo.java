package bookManager.bookRepo;

import bookManager.book.Book;

import java.util.List;

public interface BookRepo {
    public void addBook(Book book);
    public List<Book> getBook();

}
