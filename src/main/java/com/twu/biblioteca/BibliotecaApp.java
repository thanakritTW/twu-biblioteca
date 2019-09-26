package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;

public class BibliotecaApp {
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public BibliotecaApp(PrintStream printStream, BufferedReader bufferedReader){
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public static void main(String[] args) {
    }

    public void start() {
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
    }
}
