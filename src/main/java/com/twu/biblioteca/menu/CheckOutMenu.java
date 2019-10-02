package com.twu.biblioteca.menu;

import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckOutMenu extends Menu implements MenuInterface{

    public CheckOutMenu(Library library, String description, PrintStream printStream, BufferedReader bufferedReader) {
        super(library, description, printStream, bufferedReader);
    }

    public CheckOutMenu(Library library, PrintStream printStream, BufferedReader bufferedReader) {
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
