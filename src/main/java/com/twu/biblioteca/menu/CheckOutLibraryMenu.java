package com.twu.biblioteca.menu;

import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.PrintStream;

public class CheckOutLibraryMenu extends LibraryMenu implements MenuInterface{

    public CheckOutLibraryMenu(Library library, String description, PrintStream printStream, BufferedReader bufferedReader) {
        super(library, description, printStream, bufferedReader);
    }

    public CheckOutLibraryMenu(Library library, PrintStream printStream, BufferedReader bufferedReader) {
        super(library, "Check Out a Book", printStream, bufferedReader);
    }

    public void show(){
        printStream.println("Please choose a book!\nBook name: ");
        String bookName = readLine();
        if (library.checkOut(bookName)) {
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("Sorry, that book is not available");
        }
    }

    public String getDescription() {
        return description;
    }
}
