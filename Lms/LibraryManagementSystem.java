 package Lms;
/*
  Author: Jean Fernandez Rivera
  Course: CEN 3024C
  Date: 09/03/2023
  Class Name:
  Description: Represents a single book in the library management system.
 */
 import java.io.File;
 import java.io.FileNotFoundException;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.util.ArrayList;
 import java.util.Scanner;

 public class LibraryManagementSystem {
     private static Library library = new Library();
     private static LibraryManagementSystemGUI GUI;

     public static void loadFromFile(String filePath) {
         try {
             Scanner scanner = new Scanner(new File(filePath));
             while (scanner.hasNextLine()) {
                 String line = scanner.nextLine();
                 String[] parts = line.split(",");
                 if (parts.length != 6) {
                     System.out.println("Skipping malformed line: " + line);
                     continue;
                 }
                 int id = Integer.parseInt(parts[0].trim());
                 String title = parts[1].trim();
                 String author = parts[2].trim();
                 String status = parts[3].trim();
                 String dueDate = parts[4].trim();
                 String barcode = parts[5].trim();
                 var book = new Book(id, title, author, status, dueDate, barcode);
                 library.addBook(book);
             }
             scanner.close();
         } catch (FileNotFoundException e) {
             System.out.println("Error: Could not find the books file.");
         }
     }

     public static void saveToFile(ArrayList<Book> books, String filePath) {
         try {
             FileWriter writer = new FileWriter(filePath);
             for (Book book : books) {
                 writer.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + ","
                         + book.getStatus() + "," + book.getDueDate() + "," + book.getBarcode() + "\n");
             }
             writer.close();
         } catch (IOException e) {
             System.out.println("Error: Could not save the books file.");
             e.printStackTrace(); // Print the stack trace to help identify the issue
         }
     }

     public static void setGUI(LibraryManagementSystemGUI GUI) {
         LibraryManagementSystem.GUI = GUI;
     }

     public static void printBooks() {
         library.displayBooks();
     }

     public static void removeBookByBarcode(String barcode) {
         library.removeBookByBarcode(barcode);
     }

     public static void removeBookByTitle(String title) {
         library.removeBookByTitle(title);
     }

     public static void checkoutBook(String title, String barcode) {
         library.checkoutBook(title, barcode);
     }

     public static void checkinBook(String title, String barcode) {
         library.checkinBook(title, barcode);
     }

     public static void main(String[] args) throws IOException {
         String filePath = "C:\\Users\\jemif\\IdeaProjects\\Libary Management System\\src\\Lms\\Books.txt";

         loadFromFile(filePath);

         LibraryManagementSystemGUI gui = new LibraryManagementSystemGUI(new LibraryManagementSystem()); // Pass an instance of LibraryManagementSystem
         setGUI(gui);

         Scanner scanner = new Scanner(System.in);
         while (true) {
             System.out.println("1. Add new book");
             System.out.println("2. Remove a book by ID");
             System.out.println("3. Remove a book by title");
             System.out.println("4. List all books");
             System.out.println("5. Check out a book by title and barcode");
             System.out.println("6. Check in a book by title and barcode");
             System.out.println("7. Exit");

             String choice = scanner.nextLine();
             switch (choice) {
                 case "1":
                     System.out.println("Enter book ID: ");
                     int id = Integer.parseInt(scanner.nextLine());
                     System.out.println("Enter book title: ");
                     String title = scanner.nextLine();
                     System.out.println("Enter book author: ");
                     String author = scanner.nextLine();
                     System.out.println("Enter book status (checked in/checked out): ");
                     String status = scanner.nextLine();
                     System.out.println("Enter book due date (YYYY-MM-DD): ");
                     String dueDate = scanner.nextLine();
                     System.out.println("Enter book barcode: ");
                     String barcode = scanner.nextLine();
                     library.addBook(new Book(id, title, author, status, dueDate, barcode));
                     break;
                 case "2":
                     System.out.println("Enter the ID of the book to remove: ");
                     int removeId = Integer.parseInt(scanner.nextLine());
                     library.removeBookById(removeId);
                     break;
                 case "3":
                     System.out.println("Enter the title of the book to remove: ");
                     String removeTitle = scanner.nextLine();
                     library.removeBookByTitle(removeTitle);
                     break;
                 case "4":
                     printBooks();
                     break;
                 case "5":
                     System.out.println("Enter the title of the book to check out: ");
                     String checkoutTitle = scanner.nextLine();
                     System.out.println("Enter the barcode of the book to check out: ");
                     String checkoutBarcode = scanner.nextLine();
                     checkoutBook(checkoutTitle, checkoutBarcode);
                     break;
                 case "6":
                     System.out.println("Enter the title of the book to check in: ");
                     String checkinTitle = scanner.nextLine();
                     System.out.println("Enter the barcode of the book to check in: ");
                     String checkinBarcode = scanner.nextLine();
                     checkinBook(checkinTitle, checkinBarcode);
                     break;
                 case "7":
                     saveToFile(library.getAllBooks(), filePath);
                     System.out.println("Exiting. Goodbye!");
                     return;
                 default:
                     System.out.println("Invalid choice. Please try again.");
             }
         }
     }
 }