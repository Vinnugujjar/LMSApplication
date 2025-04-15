package com.lmsapplication.service;

import com.lmsapplication.entity.Book;
import com.lmsapplication.entity.User;

import java.util.*;

public class Library {
    private List<Book> books;
    private Map<String, User> users;
    private Map<String, Book> issuedBooks;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        users = new HashMap<>();
        issuedBooks = new HashMap<>();
    }

    // Method to add a new book to the library
    public void addBook(String bookID, String title, String author) {
        Book newBook = new Book(bookID, title, author);
        books.add(newBook);
        System.out.println("Book added: " + newBook);
    }

    // Method to add a new user
    public void addUser(String userID, String name) {
        User newUser = new User(userID, name);
        users.put(userID, newUser);
        System.out.println("User added: " + newUser);
    }

    // Method to issue a book to a user
    public void issueBook(String bookID, String userID) {
        Book bookToIssue = findBookByID(bookID);
        User user = users.get(userID);
        if (bookToIssue != null && bookToIssue.isAvailable() && user != null) {
            bookToIssue.setAvailable(false);  // Mark book as issued
            issuedBooks.put(bookID, bookToIssue);  // Add to issued books
            System.out.println("Book issued: " + bookToIssue + " to " + user.getName());
        } else {
            System.out.println("Book cannot be issued.");
        }
    }

    // Method to return a book
    public void returnBook(String bookID) {
        Book bookToReturn = issuedBooks.remove(bookID);
        if (bookToReturn != null) {
            bookToReturn.setAvailable(true);  // Mark book as available again
            System.out.println("Book returned: " + bookToReturn);
        } else {
            System.out.println("Book not found in issued books.");
        }
    }

    // Method to find a book by its ID
    public Book findBookByID(String bookID) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                return book;
            }
        }
        return null;
    }

    // Method to display all books in the library
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Method to search for a book by title
    public void searchBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with the title: " + title);
        }
    }
}

