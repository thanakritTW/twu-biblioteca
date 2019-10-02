package com.twu.biblioteca.menu;

import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.PrintStream;

public class ReturnMenu extends Menu implements MenuInterface{

    public ReturnMenu(Library library, String description, PrintStream printStream, BufferedReader bufferedReader) {
        super(library, description, printStream, bufferedReader);
    }

    public ReturnMenu(Library library, PrintStream printStream, BufferedReader bufferedReader) {
        super(library, "Return the Book", printStream, bufferedReader);
    }

    public void show(){
        printStream.println("Book name to return: ");
        String bookName = readLine();
        if (library.returnBook(bookName)) {
            printStream.println("Thank you for returning the book");
        } else {
            printStream.println("Sorry that is not a valid book to return");
        }
    }

    public String getDescription() {
        return description;
    }
}
