package com.twu.biblioteca;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private boolean loggedIn;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public String getPassword() {
        return password;
    }

    public User(String username, String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = "hashedpassword";
        this.loggedIn = false;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
