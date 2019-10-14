package com.twu.biblioteca.menu;

import com.twu.biblioteca.User;

import java.io.BufferedReader;
import java.io.IOException;
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
        printStream.print("Username: ");
        String username = readLine();
        printStream.print("Password: ");
        String password = readLine();
        if (login(username, password)){
            printStream.println("Successfully logged in");
        } else {
            printStream.println("username or password incorrect");
        }

    }

    private boolean login(String username,String password){
        for (User u: users){
            if (u.getUsername().equals(username) && u.getPassword().equals(password)){
                u.setLoggedIn(true);
                return true;
            }
        }
        return false;
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

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isLoggedInRequired() {
        return loggedInRequired;
    }
}
