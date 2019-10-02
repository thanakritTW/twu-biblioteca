package com.twu.biblioteca.menu;

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
    }

    public String getDescription() {
        return description;
    }
}
