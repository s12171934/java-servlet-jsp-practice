package bookManager;

import bookManager.book.*;
import bookManager.bookRepo.BookArrayList;
import bookManager.bookRepo.BookRepo;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class BookManager implements BM{
    BookRepo bookList = new BookArrayList();
    @Override
    public void addBook(HttpServletRequest req) {
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
    public void sortBook(HttpServletRequest req) {
        String type = req.getParameter("type");
        boolean asc = Boolean.parseBoolean(req.getParameter("asc"));
        bookList.sortBookList(type,asc);
    }

    @Override
    public void searchBook(HttpServletRequest req) {
        String type = req.getParameter("type");
        String search = req.getParameter("search");

    }

    @Override
    public void editBook(HttpServletRequest req) {
        String classType = req.getParameter("classType");
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        long isbn = Long.parseLong(req.getParameter("isbn"));
        LocalDate publishDate = LocalDate.parse(req.getParameter("publishDate"));
        Book book = bookList.getBook(id);

        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setIsbn(isbn);
        book.setPublishDate(publishDate);
        if(classType.equals("Ebook")){
            int size = Integer.parseInt(req.getParameter("size"));
            ((Ebook)book).setSize(size);
        } else {
            int size = Integer.parseInt(req.getParameter("size"));
            String lang = req.getParameter("lang");
            int len = Integer.parseInt(req.getParameter("len"));
            ((AudioBook)book).setSize(size);
            ((AudioBook)book).setLang(lang);
            ((AudioBook)book).setLen(len);
        }
    }

    @Override
    public void removeBook(HttpServletRequest req) {
        String[] ids = req.getParameterValues("ids");
        for(String id : ids) {
            bookList.removeBook(id);
        }
    }

    @Override
    public void checkOutBook() {

    }

    @Override
    public void checkInBook() {

    }
}
