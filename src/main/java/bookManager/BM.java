package bookManager;

import javax.servlet.http.HttpServletRequest;

public interface BM {
    public void addBook(HttpServletRequest req);
    public void sortBook(HttpServletRequest req);
    public void searchBook(HttpServletRequest req);
    public void editBook(HttpServletRequest req);
    public void removeBook(HttpServletRequest req);
    public void checkOutBook();
    public void checkInBook();
}
