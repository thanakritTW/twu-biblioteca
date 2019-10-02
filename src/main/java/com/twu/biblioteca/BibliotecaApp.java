package com.twu.biblioteca;


import com.twu.biblioteca.menu.CheckOutMenu;
import com.twu.biblioteca.menu.ListBooksMenu;
import com.twu.biblioteca.menu.MenuInterface;
import com.twu.biblioteca.menu.ReturnMenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BibliotecaApp {
    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Book> books = new ArrayList<>();
        books.add(new Book("My very First Book","Gwan",1996));
        books.add(new Book("My Second Book","GwanGwan",1970));
        Library library = new Library(books);

        HashMap<String, MenuInterface> menus = new HashMap<String, MenuInterface>();
        menus.put("1",new CheckOutMenu(library, printStream, bufferedReader));
        menus.put("2",new ListBooksMenu(library, printStream, bufferedReader));
        menus.put("3",new ReturnMenu(library, printStream, bufferedReader));

        Store store = new Store(menus, printStream, bufferedReader);
        store.start();
    }
}
