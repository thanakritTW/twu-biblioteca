package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public boolean checkOut(String bookName){
        for (Book b:books){
            if (b.getName().equals(bookName) && b.isAvailable()){
                b.borrowBook();
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName){
        for (Book b:books){
            if (b.getName().equals(bookName) && !b.isAvailable()){
                b.returnBook();
                return true;
            }
        }
        return false;
    }
}

