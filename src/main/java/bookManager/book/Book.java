package bookManager.book;

import java.time.LocalDate;

public class Book {
    private String classType;
    private String id;
    private String name;
    private String author;
    private long isbn;
    private LocalDate publishDate;
    private boolean checkOut = false;
    private String checkOutUserId;
    private LocalDate checkOutStart;
    private LocalDate checkOutEnd;

    public Book(String classType, String id,String name,String author,long isbn,LocalDate publishDate){
        this.classType = classType;
        this.id = id;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.publishDate = publishDate;
    }
    public String getClassType() {
        return classType;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }
    public String getCheckOutUserId() {
        return checkOutUserId;
    }

    public void setCheckOutUserId(String id) {
        this.checkOutUserId = id;
    }
    public LocalDate getCheckOutStart() {
        return checkOutStart;
    }

    public void setCheckOutStart(LocalDate checkOutStart) {
        this.checkOutStart = checkOutStart;
    }

    public LocalDate getCheckOutEnd() {
        return checkOutEnd;
    }

    public void setCheckOutEnd(LocalDate checkOutEnd) {
        this.checkOutEnd = checkOutEnd;
    }
}
