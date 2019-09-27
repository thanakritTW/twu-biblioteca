package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.util.List;

public class Store {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Library library;

    public Store(Library library, PrintStream printStream, BufferedReader bufferedReader) {
        this.library = library;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void start(){
        welcome();
        String action = "";
        while (!action.equals("quit")){
            listMenu();
            action = readLine();
            checkAction(action);
        }
    }

    public void welcome(){
        printStream.println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
    }

    public void listMenu() {
        String menuList = "Please select one of the following tasks\n";
        menuList += "1 : List of Books\n";
        menuList += "2 : Check out a Book\n";
        menuList += "Select: ";
        printStream.println(menuList);
    }

    public void checkOutMenu() {
        printStream.print("Please choose a book!\nBook name: ");
        String bookName = readLine();
        if (library.checkOut(bookName)) {
            printStream.println("Thank you! Enjoy the book");
        } else {
            printStream.println("Sorry, that book is not available");
        }
    }

    public void returningMenu(){

    }

    public void checkAction(String action){
        switch(action) {
            case "1":
                listBooks();
                break;
            case "2":
                checkOutMenu();
                break;
            case "quit":
                printStream.println("Bye Bye");
                break;
            default:
                printStream.println("Please select a valid option!");
        }
    }

    public void listBooks() {
        String bookList = "Name | Author | Published Year\n";
        for (Book b: library.getBooks()) {
            bookList += b.getName() + " | ";
            bookList += b.getAuthor() + " | ";
            bookList += b.getPublishedYear() + "\n";
        }
        printStream.println(bookList);
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

}
