package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<String> books = new ArrayList<>();
        Library library = new Library(books, printStream, bufferedReader);

        library.welcome();
        library.listBooks();
    }
}
