package function;

import bookManager.BM;
import bookManager.book.AudioBook;
import bookManager.book.Book;
import bookManager.book.Ebook;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class RW {
    static  String bookId;
    public static void readBooks(BM bm){
        try {
            String path = "C:\\Users\\ast08\\IdeaProjects\\bookManager";
            BufferedReader reader = new BufferedReader(new FileReader(path + "\\books\\bookIds.txt", StandardCharsets.UTF_8));
            bookId = reader.readLine();
            if(bookId == null)bookId = "";
            String[] bookIds = bookId.split(",");

            for(String id : bookIds){
               reader = new BufferedReader(new FileReader(path + "\\books\\book_" + id + ".txt", StandardCharsets.UTF_8));
               String[] bookInfo = reader.readLine().split(",");
               bm.addBook(bookInfo);
            }
        } catch (Exception e) {
        }
    }
    public static void addBook(Book book){
        try {
            String path = "C:\\Users\\ast08\\IdeaProjects\\bookManager";
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "\\books\\bookIds.txt", StandardCharsets.UTF_8));
            bookId += "," + book.getId();
            writer.write(bookId);
            writer.flush();
            writer.close();
        } catch (Exception e){}
    }
    public static void writeBook(Book book){
        try{
            String path = "C:\\Users\\ast08\\IdeaProjects\\bookManager";
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "\\books\\book_" + book.getId() + ".txt", StandardCharsets.UTF_8));

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
            writer.write(bookInfo);
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    }
    public static void deleteBook(Book book){
        try {
            String path = "C:\\Users\\ast08\\IdeaProjects\\bookManager";
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "\\books\\bookIds.txt", StandardCharsets.UTF_8));
            bookId = bookId.replace(book.getId(),"");
            bookId = bookId.replace(",,",",");
            if(bookId.charAt(0)==',')bookId = bookId.substring(1);
            if(bookId.charAt(bookId.length()-1)==',')bookId = bookId.substring(0,bookId.length()-1);
            writer.write(bookId);
            writer.flush();
            writer.close();

            File file = new File(path + "\\books\\book_" + book.getId() + ".txt");
            if(file.exists())file.delete();

        } catch (Exception e) {
        }
    }
}
