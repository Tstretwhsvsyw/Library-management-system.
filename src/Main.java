package library.main;

import library.model.Book;
import library.service.LibraryService;
import library.util.InputUtil;

public class Main {

    public static void main(String[] args) {

        LibraryService service = new LibraryService();

        while (true) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = InputUtil.sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int id = InputUtil.sc.nextInt();
                    InputUtil.sc.nextLine(); // clear buffer

                    System.out.print("Enter Title: ");
                    String title = InputUtil.sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = InputUtil.sc.nextLine();

                    service.addBook(new Book(id, title, author));
                    break;

                case 2:
                    service.viewBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = InputUtil.sc.nextInt();
                    service.issueBook(issueId);
                    break;

                case 4:
                    System.out.println("Thank you! Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
