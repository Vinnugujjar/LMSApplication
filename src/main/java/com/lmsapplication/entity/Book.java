package com.lmsapplication.entity;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isAvailable = true;  // Initially, the book is available
    }

    // Getter and Setter methods
    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Override toString method to print book details
    @Override
    public String toString() {
        return "Book ID: " + bookID + ", Title: " + title + ", Author: " + author + ", Available: " + isAvailable;
    }
}
