package com.twu.biblioteca.menu;

import com.twu.biblioteca.User;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

public class LogInMenu implements MenuInterface {
    protected List<User> users;
    protected String description;
    protected PrintStream printStream;
    protected BufferedReader bufferedReader;
    protected boolean loggedInRequired;

    public LogInMenu(List<User> users, String description, PrintStream printStream, BufferedReader bufferedReader, boolean loggedInRequired) {
        this.users = users;
        this.description = description;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.loggedInRequired = loggedInRequired;
    }

    public LogInMenu(List<User> users, PrintStream printStream, BufferedReader bufferedReader) {
        this.users = users;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    public void show(){

    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isLoggedInRequired() {
        return loggedInRequired;
    }
}
