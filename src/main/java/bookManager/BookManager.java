package bookManager;

import bookManager.book.*;
import bookManager.bookRepo.BookArrayList;
import bookManager.bookRepo.BookRepo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

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
            book = new Book("Book",id,name,author,isbn,publishDate);
        } else if(classType.equals("Ebook")){
            int size = Integer.parseInt(req.getParameter("size"));
            book = new Ebook("Ebook",id,name,author,isbn,publishDate,size);
        } else {
            int size = Integer.parseInt(req.getParameter("size"));
            String lang = req.getParameter("lang");
            int len = Integer.parseInt(req.getParameter("len"));
            book = new AudioBook("AudioBook",id,name,author,isbn,publishDate,size,lang,len);
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
    public List<Book> searchBook(HttpServletRequest req) {
        String type = req.getParameter("type");
        String search = req.getParameter("search");
        if(search == null){
            search = req.getParameter("searchStartTime") + ":" + req.getParameter("searchEndTime");
        }
        return bookList.searchBook(type,search);
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
        } else if(classType.equals("AudioBook")){
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

    public void printBook(HttpServletResponse resp){
        try {
            PrintWriter out = resp.getWriter();
            List<Book> booklist = bookList.getBookList();
            if(booklist.size() == 0){
                out.println("<a>" + " - / - " + "</a><br>");
            } else {
                out.println("<form action=\"/bookManager/bookInfo.jsp\" method=\"post\">");
                for (Book book : booklist) {
                    out.println("<input type=\"submit\" name=\"id\" value=\"" + book.getId() + "\"><a> / " + book.getName() + " / " + book.getClassType() + "</a><br>");
                }
                out.println("</form>");
            }
        } catch (Exception e){}
    }

    @Override
    public Book getBook(String id) {
        return bookList.getBook(id);
    }

    @Override
    public void checkOutBook() {

    }

    @Override
    public void checkInBook() {

    }
}
