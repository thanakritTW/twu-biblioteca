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

    public void changeAvailability() {
        availability = !availability;
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
