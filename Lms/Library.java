package Lms;

/**
 * Author: Jean Fernandez Rivera
 * Course: CEN 3024C
 * Date: 09/03/2023
 * Class Name:
 * Description: Represents a single book in the library management system.
 */
import java.util.ArrayList;

public class Library {

    public static Library libraryInstance = new Library();
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public static Library getInstance() {
        return libraryInstance;
    }

    public static void checkinBook(String checkinTitle, String checkinBarcode) {
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBookById(int id) {
        books.removeIf(book -> book.getId() == id);
    }

    public void removeBookByTitle(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    public void removeBookByBarcode(String barcode) {
        books.removeIf(book -> book.getBarcode().equals(barcode));
    }

    public void checkoutBook(String title, String dueDate) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getStatus().equals("checked in")) {
                book.setStatus("checked out");
                book.setDueDate(dueDate);
                return;
            }
        }
        System.out.println("Book not found or already checked out.");
    }

    public void checkinBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.getStatus().equals("checked out")) {
                book.setStatus("checked in");
                book.setDueDate("null");
                return;
            }
        }
        System.out.println("Book not found or already checked in.");
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    public ArrayList<Book> getAllBooks() {
        return books;
    }

    public Book getBookByTitle(String title) {
        // Implement this method to retrieve a book by title
        return null;
    }
}

