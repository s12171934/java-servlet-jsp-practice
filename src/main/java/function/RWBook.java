package function;

import bookManager.BM;
import bookManager.book.AudioBook;
import bookManager.book.Book;
import bookManager.book.Ebook;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class RWBook {
    static String bookId;
    static String path = "C:\\Users\\ast08\\IdeaProjects\\bookManager\\data\\books\\";
    public static void readBooks(BM bm){
        try {

            BufferedReader reader = new BufferedReader(new FileReader(path + "bookIds.txt", StandardCharsets.UTF_8));
            bookId = reader.readLine();
            if(bookId == null)bookId = "";
            String[] bookIds = bookId.split(",");

            for(String id : bookIds){
               reader = new BufferedReader(new FileReader(path + "book_" + id + ".txt", StandardCharsets.UTF_8));
               String info = reader.readLine();
               String[] bookInfo = info.split("\\|")[0].split(",");
               String[] checkOutInfo = info.split("\\|")[1].split(",");
               bm.addBook(bookInfo,checkOutInfo);
            }
        } catch (Exception e) {
        }
    }
    public static void addBook(Book book){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "bookIds.txt", StandardCharsets.UTF_8));
            bookId += "," + book.getId();
            writer.write(bookId);
            writer.flush();
            writer.close();
        } catch (Exception e){}
    }
    public static void writeBook(Book book){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "book_" + book.getId() + ".txt", StandardCharsets.UTF_8));

            String classType = book.getClassType();
            String id = book.getId();
            String name = book.getName();
            String author = book.getAuthor();
            String isbn = String.valueOf(book.getIsbn());
            String publishDate = String.valueOf(book.getPublishDate());
            String bookInfo = classType + "," + id + "," + name + "," + author + "," + isbn + "," + publishDate;
            if(!classType.equals("Book")){
                String size = String.valueOf(((Ebook)book).getSize());
                bookInfo += "," + size;
                if(classType.equals("AudioBook")){
                    String lang = ((AudioBook)book).getLang();
                    String len = String.valueOf(((AudioBook)book).getLen());
                    bookInfo += "," + lang + "," + len;
                }
            }

            String checkOut = book.isCheckOut()? "true":"false";
            String checkOutUserId = book.getCheckOutUserId();
            String checkOutStart = String.valueOf(book.getCheckOutStart());
            String checkOutEnd = String.valueOf(book.getCheckOutEnd());
            String checkOutInfo = checkOut + "," + checkOutUserId + "," + checkOutStart + "," + checkOutEnd;

            bookInfo += "\\|" + checkOutInfo;

            writer.write(bookInfo);
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    }
    public static void deleteBook(Book book){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "bookIds.txt", StandardCharsets.UTF_8));
            bookId = bookId.replace(book.getId(),"");
            bookId = bookId.replace(",,",",");
            if(bookId.charAt(0)==',')bookId = bookId.substring(1);
            if(bookId.charAt(bookId.length()-1)==',')bookId = bookId.substring(0,bookId.length()-2);
            writer.write(bookId);
            writer.flush();
            writer.close();

            File file = new File(path + "book_" + book.getId() + ".txt");
            if(file.exists())file.delete();

        } catch (Exception e) {
        }
    }
}
