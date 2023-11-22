package bookManager.bookRepo;

import bookManager.book.Book;

import java.util.ArrayList;
import java.util.List;

public class BookArrayList implements BookRepo{
    private ArrayList<Book> bookList = new ArrayList<>();
    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }

    @Override
    public List<Book> getBook() {
        return null;
    }
}
