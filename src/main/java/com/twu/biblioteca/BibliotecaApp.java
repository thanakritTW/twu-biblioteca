package com.twu.biblioteca;


import com.twu.biblioteca.menu.CheckOutLibraryMenu;
import com.twu.biblioteca.menu.ListBooksLibraryMenu;
import com.twu.biblioteca.menu.MenuInterface;
import com.twu.biblioteca.menu.ReturnLibraryMenu;

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

        Map<String, MenuInterface> menus = new HashMap<String, MenuInterface>();
        menus.put("1",new CheckOutLibraryMenu(library, printStream, bufferedReader));
        menus.put("2",new ListBooksLibraryMenu(library, printStream, bufferedReader));
        menus.put("3",new ReturnLibraryMenu(library, printStream, bufferedReader));

        Store store = new Store(menus, printStream, bufferedReader);
        store.start();
    }
}
