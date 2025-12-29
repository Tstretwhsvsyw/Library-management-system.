package library.service;

import library.dao.LibraryDB;
import library.model.Book;

public class LibraryService {

    // Add new book
    public void addBook(Book book) {
        LibraryDB.books.add(book);
        System.out.println("Book added successfully!");
    }

    // View all books
    public void viewBooks() {
        if (LibraryDB.books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        System.out.println("ID | Title | Author | Issued");
        for (Book b : LibraryDB.books) {
            System.out.println(
                    b.getId() + " | " +
                            b.getTitle() + " | " +
                            b.getAuthor() + " | " +
                            b.isIssued()
            );
        }
    }

    // Issue a book
    public void issueBook(int id) {
        for (Book b : LibraryDB.books) {
            if (b.getId() == id && !b.isIssued()) {
                b.setIssued(true);
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not available or already issued.");
    }
}
