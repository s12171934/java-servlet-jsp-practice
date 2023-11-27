package bookManager.bookRepo;

import bookManager.book.AudioBook;
import bookManager.book.Book;
import bookManager.book.Ebook;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookArrayList implements BookRepo{
    private ArrayList<Book> bookList = new ArrayList<>();
    @Override
    public void addBook(Book book) {
        bookList.add(book);
    }
    @Override
    public Book getBook(String id) {
        return bookList.stream().filter(book -> book.getId().equals(id)).toArray(Book[]::new)[0];
    }
    @Override
    public void removeBook(String id) {
        bookList.removeIf(book -> book.getId().equals(id));
    }
    @Override
    public void sortBookList(String type, boolean asc) {
        int ascInt = asc? 1: -1;
        switch (type){
            case "id":
                bookList.sort((book1,book2) -> Integer.compare(ascInt * book1.getId().compareTo(book2.getId()),0));
                break;
            case "name":
                bookList.sort((book1,book2) -> Integer.compare(ascInt * book1.getName().compareTo(book2.getName()),0));
                break;
            case "author":
                bookList.sort((book1,book2) -> Integer.compare(ascInt * book1.getAuthor().compareTo(book2.getAuthor()),0));
                break;
            case "isbn":
                bookList.sort((book1,book2) -> Integer.compare(ascInt * Long.compare(book1.getIsbn(),book2.getIsbn()),0));
                break;
            case "publishDate":
                bookList.sort((book1,book2) -> Integer.compare(ascInt * book1.getPublishDate().compareTo(book2.getPublishDate()),0));
                break;
            case "size":
                bookList.sort((book1,book2) -> Integer.compare(ascInt * Integer.compare(((Ebook)book1).getSize(),((Ebook)book2).getSize()),0));
                break;
            case "lang":
                bookList.sort((book1,book2) -> Integer.compare(ascInt * ((AudioBook)book1).getLang().compareTo(((AudioBook)book2).getLang()),0));
                break;
            case "len":
                bookList.sort((book1,book2) -> Integer.compare(ascInt * Integer.compare(((AudioBook)book1).getLen(),((AudioBook)book2).getLen()),0));
                break;
            default:
                break;
        }
    }
    @Override
    public List<Book> searchBook(String type, String search) {
        ArrayList<Book> bookList2;
        switch (type){
            case "id":
                bookList2 = new ArrayList<>(List.of(bookList.stream().filter(book -> book.getId().contains(search)).toArray(Book[]::new)));
                return bookList2;
            case "name":
                bookList2 = new ArrayList<>(List.of(bookList.stream().filter(book -> book.getName().contains(search)).toArray(Book[]::new)));
                return bookList2;
            case "author":
                bookList2 = new ArrayList<>(List.of(bookList.stream().filter(book -> book.getAuthor().contains(search)).toArray(Book[]::new)));
                return bookList2;
            case "isbn":
                bookList2 = new ArrayList<>(List.of(bookList.stream().filter(book -> book.getIsbn() == Long.parseLong(search)).toArray(Book[]::new)));
                return bookList2;
            case "publishDate":
                LocalDate start = LocalDate.parse(search.split(":")[0]);
                LocalDate end = LocalDate.parse(search.split(":")[1]);
                bookList2 = new ArrayList<>(List.of(bookList.stream().filter(book -> book.getPublishDate().isAfter(start)&&book.getPublishDate().isBefore(end)).toArray(Book[]::new)));
                return bookList2;
            case "lang":
                bookList2 = new ArrayList<>(List.of(bookList.stream().filter(book -> ((AudioBook)book).getLang().equals(search)).toArray(Book[]::new)));
                return bookList2;
            default:
                return null;
        }
    }
}
