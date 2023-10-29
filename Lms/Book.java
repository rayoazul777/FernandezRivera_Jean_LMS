package Lms;

/**
 * Author: Jean Fernandez Rivera
 * Course: CEN 3024C
 * Date: 09/03/2023
 * Class Name:
 * Description: Represents a single book in the library management system.
 */
public class Book {
    private final int id;
    private final String title;
    private final String author;
    private String status;
    private String dueDate;
    private final String barcode;

    public Book(int id, String title, String author, String status, String dueDate, String barcode) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = status;
        this.dueDate = dueDate;
        this.barcode = barcode;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
    public String getBarcode() {
        return barcode;
    }
    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + ", " + title + ", " + author + ", " + status + ", " + dueDate;
    }
}
