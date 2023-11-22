package bookManager;

import bookManager.book.*;
import bookManager.bookRepo.BookArrayList;
import bookManager.bookRepo.BookRepo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class BookManager implements BM{
    BookRepo bookList = new BookArrayList();
    @Override
    public void addBook(HttpServletRequest req, HttpServletResponse resp) {
        String classType = req.getParameter("classType");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        long isbn = Long.parseLong(req.getParameter("isbn"));
        LocalDate publishDate = LocalDate.parse(req.getParameter("publishDate"));
        Book book;

        if(classType.equals("Book")){
            book = new Book(id,name,author,isbn,publishDate);
        } else if(classType.equals("Ebook")){
            int size = Integer.parseInt(req.getParameter("size"));
            book = new Ebook(id,name,author,isbn,publishDate,size);
        } else {
            int size = Integer.parseInt(req.getParameter("size"));
            String lang = req.getParameter("lang");
            int len = Integer.parseInt(req.getParameter("len"));
            book = new AudioBook(id,name,author,isbn,publishDate,size,lang,len);
        }
        bookList.addBook(book);
    }

    @Override
    public void sortBook() {

    }

    @Override
    public void searchBook() {

    }

    @Override
    public void editBook() {

    }

    @Override
    public void removeBook() {

    }

    @Override
    public void checkOutBook() {

    }

    @Override
    public void checkInBook() {

    }
}
