package bookManager.book;

import java.time.LocalDate;

public class Ebook extends Book{
    private final String classType = "Ebook";
    private int size;
    public Ebook(String id, String name, String author, long isbn, LocalDate publishDate, int size) {
        super(id, name, author, isbn, publishDate);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
