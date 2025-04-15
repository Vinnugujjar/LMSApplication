package com.lmsapplication;

import com.lmsapplication.service.Library;
import java.util.Scanner;

public class LibraryManagementSystem {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Adding some books and users for testing purposes
        library.addBook("B001", "The Great Gatsby", "F. Scott Fitzgerald");
        library.addBook("B002", "1984", "George Orwell");
        library.addUser("U001", "John Doe");
        library.addUser("U002", "Jane Smith");

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    library.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    String issueBookID = scanner.nextLine();
                    System.out.print("Enter User ID: ");
                    String issueUserID = scanner.nextLine();
                    library.issueBook(issueBookID, issueUserID);
                    break;

                case 3:
                    System.out.print("Enter Book ID to return: ");
                    String returnBookID = scanner.nextLine();
                    library.returnBook(returnBookID);
                    break;

                case 4:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    library.searchBook(searchTitle);
                    break;

                case 5:
                    System.out.println("Exiting the system...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
