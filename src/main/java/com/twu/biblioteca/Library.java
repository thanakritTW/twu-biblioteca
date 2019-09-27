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
        for (Book book:books){
            if (book.getName().equals(bookName) && book.isAvailable()){
                book.changeAvailability();
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName){
        for (Book book:books){
            if (book.getName().equals(bookName) && !book.isAvailable()){
                book.changeAvailability();
                return true;
            }
        }
        return false;
    }
}

