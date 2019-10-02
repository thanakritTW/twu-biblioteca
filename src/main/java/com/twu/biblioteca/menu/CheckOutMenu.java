package com.twu.biblioteca.menu;

import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.PrintStream;

public class CheckOutMenu extends Menu implements MenuInterface{

    public CheckOutMenu(Library library, String description, PrintStream printStream, BufferedReader bufferedReader) {
        super(library, description, printStream, bufferedReader);
    }

    public CheckOutMenu(Library library, PrintStream printStream, BufferedReader bufferedReader) {
        super(library, "Check Out a Book", printStream, bufferedReader);
    }

    public void show(){
    }

    public String getDescription() {
        return description;
    }
}
