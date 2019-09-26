package com.twu.biblioteca;

public class Book {
    private String name;
    private String author;
    private int publishedYear;

    public Book(String name, String author, int publishedYear){
        this.name = name;
        this.author = author;
        this.publishedYear = publishedYear;
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
