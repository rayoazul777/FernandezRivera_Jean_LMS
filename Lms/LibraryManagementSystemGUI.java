package Lms;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagementSystemGUI {
    private JFrame frame;
    private JTextField fileNameField;
    private JButton loadButton;
    private JButton printButton;
    private JButton removeBarcodeButton;
    private JButton removeTitleButton;
    private JButton checkoutButton;
    private JButton checkinButton;
    private LibraryManagementSystem lms;

    public LibraryManagementSystemGUI(LibraryManagementSystem lms) {
        this.lms = lms;

        frame = new JFrame("Library Management System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        fileNameField = new JTextField(20);
        frame.add(fileNameField);

        loadButton = new JButton("Load");
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String filePath = fileNameField.getText();
                lms.loadFromFile(filePath);
                // Add code to refresh GUI if necessary
            }
        });
        frame.add(loadButton);

        printButton = new JButton("Print Books");
        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lms.printBooks();
            }
        });
        frame.add(printButton);

        removeBarcodeButton = new JButton("Remove by Barcode");
        removeBarcodeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String barcode = JOptionPane.showInputDialog("Enter Barcode:");
                lms.removeBookByBarcode(barcode);
            }
        });
        frame.add(removeBarcodeButton);

        removeTitleButton = new JButton("Remove by Title");
        removeTitleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter Title:");
                lms.removeBookByTitle(title);
            }
        });
        frame.add(removeTitleButton);

        checkoutButton = new JButton("Checkout Book");
        checkoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter Title:");
                String barcode = JOptionPane.showInputDialog("Enter Barcode:");
                lms.checkoutBook(title, barcode);
            }
        });
        frame.add(checkoutButton);

        checkinButton = new JButton("Checkin Book");
        checkinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter Title:");
                String barcode = JOptionPane.showInputDialog("Enter Barcode:");
                lms.checkinBook(title, barcode);
            }
        });
        frame.add(checkinButton);

        frame.setVisible(true);
    }
}


