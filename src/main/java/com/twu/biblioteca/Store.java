package com.twu.biblioteca;

import com.twu.biblioteca.menu.MenuInterface;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.IOException;
import java.util.Map;

public class Store {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Map<String, MenuInterface> menus;

    public Store(Map<String, MenuInterface> menus, PrintStream printStream, BufferedReader bufferedReader) {
        this.menus = menus;
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
        for (Map.Entry<String, MenuInterface> entry : menus.entrySet()) {
            menuList += entry.getKey() + " : " + entry.getValue().getDescription() +"\n";
        }
        printStream.println(menuList);
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
