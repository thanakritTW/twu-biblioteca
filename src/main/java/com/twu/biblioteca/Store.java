package com.twu.biblioteca;

import com.twu.biblioteca.menu.MenuInterface;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Store {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Map<String, MenuInterface> menus;
    private List<User> users;

    public Store(Map<String, MenuInterface> menus,List<User> users, PrintStream printStream, BufferedReader bufferedReader) {
        this.menus = menus;
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
        this.users = users;
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
        for (Map.Entry<String, MenuInterface> entry : menus.entrySet()) {
            MenuInterface menu = entry.getValue();
            if (menu.isLoggedInRequired()){
                if (isUserLogIn()){
                    menuList += entry.getKey() + " : " + menu.getDescription() +"\n";
                }
            } else {
                menuList += entry.getKey() + " : " + menu.getDescription() +"\n";
            }
        }
        printStream.println(menuList);
    }

    private boolean isUserLogIn(){
        for (User u:users){
            if (u.isLoggedIn()){
                return true;
            }
        }
        return false;
    }

    public void checkAction(String action){
        if (action.equals("quit")){
            printStream.println("Bye Bye");
            return;
        } else if (menus.containsKey(action)) {
            menus.get(action).show();
            return;
        } else {
            printStream.println("Please select a valid option!");
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
}
