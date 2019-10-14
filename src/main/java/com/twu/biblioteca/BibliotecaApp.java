package com.twu.biblioteca;


import com.twu.biblioteca.menu.*;

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
        List<User> users = new ArrayList<>();
        users.add(new User("142-7777", "Gwan",
                "gwangwan@thoughtworks.com","0800000000"));


        List<Book> books = new ArrayList<>();
        books.add(new Book("My very First Book","Gwan",1996));
        books.add(new Book("My Second Book","GwanGwan",1970));
        Library library = new Library(books);

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Joker","Todd Phillips", 2019,9));
        movies.add(new Movie("One Piece: Stampede","Takashi Otsuka", 2019,10));
        MovieShop movieShop = new MovieShop(movies);

        Map<String, MenuInterface> menus = new HashMap<String, MenuInterface>();
        menus.put("1",new CheckOutLibraryMenu(library, printStream, bufferedReader));
        menus.put("2",new ListBooksLibraryMenu(library, printStream, bufferedReader));
        menus.put("3",new ReturnLibraryMenu(library, printStream, bufferedReader));
        menus.put("4",new ListMoviesMovieShopMenu(movieShop, printStream, bufferedReader));
        menus.put("5",new CheckOutMovieShopMenu(movieShop, printStream, bufferedReader));
        menus.put("6",new LogInMenu(users, printStream, bufferedReader));

        Store store = new Store(menus, printStream, bufferedReader);
        store.start();
    }
}
