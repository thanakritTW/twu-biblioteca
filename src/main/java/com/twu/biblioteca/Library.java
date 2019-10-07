package com.twu.biblioteca;

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
                b.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String bookName){
        for (Book b:books){
            if (b.getName().equals(bookName) && !b.isAvailable()){
                b.setAvailable(true);
                return true;
            }
        }
        return false;
    }
}

