package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.util.List;

public class Library {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private List<Book> books;
    private List<FunctionalInterface> menu;

    public Library(List<Book> books, PrintStream printStream, BufferedReader bufferedReader) {
        this.books = books;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void listBooks(){
        printStream.println(displayBookInformation());
    }

    private String displayBookInformation(){
        String bookList = "Name | Author | Published Year\n";
        for (Book b: books) {
            bookList += b.getName() + " | ";
            bookList += b.getAuthor() + " | ";
            bookList += b.getPublishedYear() + "\n";
        }
        return bookList;
    }

    public void showMenu(){
        String menuList = "Please select one of the following tasks\n";
        menuList += "1 : List of Books\n";
        menuList += "Select: ";

        printStream.print(menuList);
        String action = readLine();
        if (action.equals("1")){
            listBooks();
        }
    }

    private String readLine(){
        String action = null;
        try {
            action = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return action;
    }

    public void welcome(){
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
    }
}

