package com.lmsapplication.entity;

public class User {
    private String userID;
    private String name;

    // Constructor
    public User(String userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    // Getter methods
    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    // Override toString method to print user details
    @Override
    public String toString() {
        return "User ID: " + userID + ", Name: " + name;
    }
}
