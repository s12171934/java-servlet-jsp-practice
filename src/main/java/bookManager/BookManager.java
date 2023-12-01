package bookManager;

import bookManager.book.*;
import bookManager.bookRepo.BookArrayList;
import bookManager.bookRepo.BookRepo;
import function.RWBook;
import function.RWUser;
import userManager.UserManager;

import javax.servlet.ServletContext;
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
        for(Book book : bookList.getBookList()){
            if(id.equals(book.getId()))return;
        }
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
        RWBook.addBook(book);
        RWBook.writeBook(book);
    }
    @Override
    public void addBook(String[] bookInfo,String[] checkOutInfo) {
        String classType = bookInfo[0];
        String id = bookInfo[1];
        String name = bookInfo[2];
        String author = bookInfo[3];
        long isbn = Long.parseLong(bookInfo[4]);
        LocalDate publishDate = LocalDate.parse(bookInfo[5]);
        Book book;

        if(classType.equals("Book")){
            book = new Book("Book",id,name,author,isbn,publishDate);
        } else if(classType.equals("Ebook")){
            int size = Integer.parseInt(bookInfo[6]);
            book = new Ebook("Ebook",id,name,author,isbn,publishDate,size);
        } else {
            int size = Integer.parseInt(bookInfo[6]);
            String lang = bookInfo[7];
            int len = Integer.parseInt(bookInfo[8]);
            book = new AudioBook("AudioBook",id,name,author,isbn,publishDate,size,lang,len);
        }

        boolean checkOut = Boolean.parseBoolean(checkOutInfo[0]);
        book.setCheckOut(checkOut);
        if(checkOut){
            book.setCheckOutUserId(checkOutInfo[1]);
            book.setCheckOutStart(LocalDate.parse(checkOutInfo[2]));
            book.setCheckOutEnd(LocalDate.parse(checkOutInfo[3]));
        }

        bookList.addBook(book);
    }
    @Override
    public void sortBook(HttpServletRequest req) {
        String type = req.getParameter("type");
        boolean asc = Boolean.parseBoolean(req.getParameter("asc"));
        bookList.sortBookList(type,asc);
        sortSearchBookList(req,type,asc);
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
    public void sortSearchBookList(HttpServletRequest req, String type, boolean asc) {
        ServletContext sc = req.getServletContext();
        try {
            List<Book> bookList2 = (List<Book>) sc.getAttribute("searchBook");
            int ascInt = asc ? 1 : -1;
            switch (type) {
                case "id":
                    bookList2.sort((book1, book2) -> Integer.compare(ascInt * book1.getId().compareTo(book2.getId()), 0));
                    break;
                case "name":
                    bookList2.sort((book1, book2) -> Integer.compare(ascInt * book1.getName().compareTo(book2.getName()), 0));
                    break;
                case "author":
                    bookList2.sort((book1, book2) -> Integer.compare(ascInt * book1.getAuthor().compareTo(book2.getAuthor()), 0));
                    break;
                case "isbn":
                    bookList2.sort((book1, book2) -> Integer.compare(ascInt * Long.compare(book1.getIsbn(), book2.getIsbn()), 0));
                    break;
                case "publishDate":
                    bookList2.sort((book1, book2) -> Integer.compare(ascInt * book1.getPublishDate().compareTo(book2.getPublishDate()), 0));
                    break;
                case "size":
                    bookList2.sort((book1, book2) -> Integer.compare(ascInt * Integer.compare(((Ebook) book1).getSize(), ((Ebook) book2).getSize()), 0));
                    break;
                case "lang":
                    bookList2.sort((book1, book2) -> Integer.compare(ascInt * ((AudioBook) book1).getLang().compareTo(((AudioBook) book2).getLang()), 0));
                    break;
                case "len":
                    bookList2.sort((book1, book2) -> Integer.compare(ascInt * Integer.compare(((AudioBook) book1).getLen(), ((AudioBook) book2).getLen()), 0));
                    break;
                default:
                    break;
            }
            sc.setAttribute("searchBook",bookList2);
        } catch (Exception e){
        }
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
        RWBook.writeBook(book);
    }
    @Override
    public void removeBook(HttpServletRequest req) {
        String[] ids = req.getParameterValues("ids");
        for(String sId : ids) {
            RWBook.deleteBook(bookList.getBook(sId));
            bookList.removeBook(sId);
        }
    }
    public String printBook(HttpServletRequest req){
        String data = "";
            List<Book> bookList1;
            ServletContext sc = req.getServletContext();
            String url = "/bookManager/bookInfo.jsp";
            boolean remove = false;
            if(sc.getAttribute("removeBook")!=null && sc.getAttribute("removeBook").equals("true")){
                url = "/book-manager";
                remove = true;
            }
            if(sc.getAttribute("search") != null && sc.getAttribute("search").equals("true")){
                bookList1 = (List<Book>)req.getServletContext().getAttribute("searchBook");
            } else{
                bookList1 = bookList.getBookList();
            }
            if(bookList1.isEmpty()){
                data += "<a>" + " - / - " + "</a><br>";
            } else {
                data += "<form action=\"" + url + "\" method=\"post\">";
                for (Book book : bookList1) {
                    data += "<input type=\"" + (remove?"checkbox":"submit") + "\" name=\"" + (remove?"ids":"id") + "\" value=\"" + book.getId() + "\"><a>"
                            + (remove?book.getId():"") + " / " + book.getName() + " / " + book.getClassType() + "</a><br>";
                }
                if(remove){
                    data += "<input type=\"submit\" name=\"feature\" value=\"removeBook\">";
                }
                data += "</form>";
            }
            return data;
    }
    @Override
    public Book getBook(String id) {
        return bookList.getBook(id);
    }
    @Override
    public void checkOutBook(HttpServletRequest req) {
        ServletContext sc = req.getServletContext();
        Book book = (Book)sc.getAttribute("Book");
        book.setCheckOut(true);
        book.setCheckOutUserId(req.getParameter("id"));
        book.setCheckOutStart(LocalDate.now());
        book.setCheckOutEnd(LocalDate.now().plusWeeks(1));
        RWBook.writeBook(book);
    }

    @Override
    public void checkInBook(HttpServletRequest req) {
        ServletContext sc = req.getServletContext();
        Book book = (Book)sc.getAttribute("Book");
        book.setCheckOut(false);
        book.setCheckOutUserId(null);
        book.setCheckOutStart(null);
        book.setCheckOutEnd(null);
        RWBook.writeBook(book);
    }
}
