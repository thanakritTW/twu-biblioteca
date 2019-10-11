package com.twu.biblioteca.menu;

import com.twu.biblioteca.Library;
import com.twu.biblioteca.MovieShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class MovieShopMenu{
    protected MovieShop movieShop;
    protected String description;
    protected PrintStream printStream;
    protected BufferedReader bufferedReader;
    protected boolean loggedInRequired;

    public MovieShopMenu(MovieShop movieShop, String description, PrintStream printStream, BufferedReader bufferedReader, boolean loggedInRequired) {
        this.movieShop = movieShop;
        this.description = description;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.loggedInRequired = loggedInRequired;
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
