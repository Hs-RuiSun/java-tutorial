package com.ruby.sun.stream;

public class Book {
    private String title;
    private String authorFName;
    private String authorLName;
    private int pages;

    public Book(String title, String authorFName, String authorLName, int pages) {
        this.title = title;
        this.authorFName = authorFName;
        this.authorLName = authorLName;
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorFName() {
        return authorFName;
    }

    public String getAuthorLName() { return authorLName;}

    public int getPages() { return pages;}

    public String toString() { return getTitle() + " Written By: " + getAuthorFName() + " " + getAuthorLName() + "\n";}
}
