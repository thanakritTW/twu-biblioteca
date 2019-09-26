package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

public class Library {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private List<Book> books;

    public Library(List<Book> books, PrintStream printStream, BufferedReader bufferedReader) {
        this.books = books;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void listBooks(){
        printStream.println(displayBookInformation());
    }

    private String displayBookInformation(){
        String bookList = "Name | Author | Published Year\n";
        for (Book b: books) {
            bookList += b.getName() + " | ";
            bookList += b.getAuthor() + " | ";
            bookList += b.getPublishedYear() + "\n";
        }
        return bookList;
    }

    public void welcome(){
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
    }
}