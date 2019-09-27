package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int publishedYear;
    private boolean isAvailable;

    public Book(String name, String author, int publishedYear){
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
        isAvailable = true;
    }

    public boolean getAvailibility() {
        return isAvailable;
    }

    public void changeAvailibility() {
        isAvailable = !isAvailable;
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
