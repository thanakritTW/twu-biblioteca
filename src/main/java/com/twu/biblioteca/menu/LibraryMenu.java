package com.twu.biblioteca.menu;

import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class LibraryMenu {
    protected Library library;
    protected String description;
    protected PrintStream printStream;
    protected BufferedReader bufferedReader;

    public LibraryMenu(Library library, String description, PrintStream printStream, BufferedReader bufferedReader) {
        this.library = library;
        this.description = description;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    protected String readLine(){
        String action = null;
        try {
            action = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return action;
    }
}
