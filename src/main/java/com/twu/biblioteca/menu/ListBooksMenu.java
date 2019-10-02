package com.twu.biblioteca.menu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.PrintStream;

public class ListBooksMenu extends Menu implements MenuInterface{

    public ListBooksMenu(Library library, String description, PrintStream printStream, BufferedReader bufferedReader) {
        super(library, description, printStream, bufferedReader);
    }

    public ListBooksMenu(Library library, PrintStream printStream, BufferedReader bufferedReader) {
        super(library, "Show Books", printStream, bufferedReader);
    }

    public void show(){
        String bookList = "Name | Author | Published Year\n";
        for (Book b: library.getBooks()) {
            if (b.isAvailable()){
                bookList += b.getName() + " | ";
                bookList += b.getAuthor() + " | ";
                bookList += b.getPublishedYear() + "\n";
            }
        }
        printStream.println(bookList);
    }

    public String getDescription() {
        return description;
    }
}
