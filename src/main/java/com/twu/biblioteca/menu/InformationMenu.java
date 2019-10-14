package com.twu.biblioteca.menu;

import com.twu.biblioteca.User;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.List;

public class InformationMenu implements MenuInterface {
    private List<User> users;
    private String description;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private boolean loggedInRequired;

    public InformationMenu(List<User> users, String description, PrintStream printStream, BufferedReader bufferedReader, boolean loggedInRequired) {
        this.users = users;
        this.description = description;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.loggedInRequired = loggedInRequired;
    }

    public InformationMenu(List<User> users, PrintStream printStream, BufferedReader bufferedReader) {
        this.users = users;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.description = "Show User Information";
        this.loggedInRequired = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLoggedInRequired() {
        return loggedInRequired;
    }

    public void show(){
        User u = getLoggedInUser();
        if (u != null){
            String f = "Name: %s\nEmail: %s\nPhone Number: %s";
            String out = String.format(f,u.getName(),u.getEmail(),u.getPhoneNumber());
            printStream.println(out);
        }
    }

    private User getLoggedInUser(){
        for (User u: users){
            if(u.isLoggedIn()){
                return u;
            }
        }
        return null;
    }
}
