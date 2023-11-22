package bookManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BM {
    public void addBook(HttpServletRequest req, HttpServletResponse resp);
    public void sortBook();
    public void searchBook();
    public void editBook();
    public void removeBook();
    public void checkOutBook();
    public void checkInBook();
}
