package com.twu.biblioteca.menu;

import com.twu.biblioteca.MovieShop;

import java.io.BufferedReader;
import java.io.PrintStream;

public class CheckOutMovieShopMenu extends MovieShopMenu implements MenuInterface {
    public CheckOutMovieShopMenu(MovieShop movieShop, String description, PrintStream printStream, BufferedReader bufferedReader) {
        super(movieShop, description, printStream, bufferedReader,true);
    }

    public CheckOutMovieShopMenu(MovieShop movieShop,PrintStream printStream, BufferedReader bufferedReader) {
        super(movieShop, "Check out a movie", printStream, bufferedReader,true);
    }

    public CheckOutMovieShopMenu(MovieShop movieShop, String description, PrintStream printStream, BufferedReader bufferedReader, boolean loggedInRequired) {
        super(movieShop, description, printStream, bufferedReader, loggedInRequired);
    }
    
    public boolean isLoggedInRequired(){
        return this.loggedInRequired;
    }

    public String getDescription() {
        return this.description;
    }

    public void show(){
        printStream.println("Please choose a Movie!\nBook name: ");
        String bookName = readLine();
        if (movieShop.checkOut(bookName)) {
            printStream.println("Thank you! Enjoy the movie");
        } else {
            printStream.println("Sorry, that movie is not available");
        }
    }
}
