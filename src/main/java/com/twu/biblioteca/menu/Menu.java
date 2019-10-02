package com.twu.biblioteca.menu;

import com.twu.biblioteca.Library;

import java.io.BufferedReader;
import java.io.PrintStream;

public class Menu{
    protected Library library;
    protected String description;
    protected PrintStream printStream;
    protected BufferedReader bufferedReader;

    public Menu(Library library, String description, PrintStream printStream, BufferedReader bufferedReader) {
        this.library = library;
        this.description = description;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }
}
