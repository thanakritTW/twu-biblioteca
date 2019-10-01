package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int publishedYear;
    private boolean availability;

    public Book(String name, String author, int publishedYear){
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        availability = true;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void borrowBook() {
        availability = false;
    }

    public void returnBook() {
        availability = true;
    }

    public String getName(){
        return name;
    }

    public String getAuthor(){
        return author;
    }

    public int getPublishedYear(){
        return publishedYear;
    }

}
