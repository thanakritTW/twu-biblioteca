package com.twu.biblioteca;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;

    public User(String username, String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = "hashedpassword";
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
}
