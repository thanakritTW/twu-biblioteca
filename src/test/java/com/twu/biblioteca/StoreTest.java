package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.twu.biblioteca.menu.*;
import org.junit.Test;
import org.junit.Before;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class StoreTest {
    private Store store;
    private Map<String, MenuInterface> menus;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private MenuInterface menu1;
    private MenuInterface menu2;
    private MenuInterface menu3;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);

        menus = new HashMap<>();

        List<User> users = new ArrayList<>();
        users.add(new User("142-7777", "Gwan",
                "gwangwan@thoughtworks.com","0800000000"));

        Map<String, MenuInterface> menus = new HashMap<String, MenuInterface>();

        menu1 = mock(MenuInterface.class);
        menu2 = mock(MenuInterface.class);
        menu3 = mock(MenuInterface.class);

        when(menu1.getDescription()).thenReturn("This required log in");
        when(menu1.isLoggedInRequired()).thenReturn(true);
        when(menu1.getDescription()).thenReturn("This does not required log in");
        when(menu1.isLoggedInRequired()).thenReturn(false);
        when(menu1.getDescription()).thenReturn("This also does not required log in");
        when(menu1.isLoggedInRequired()).thenReturn(false);

        menus.put("1",menu1);
        menus.put("2",menu2);
        menus.put("3",menu3);

        store = new Store(menus, printStream, bufferedReader);
    }

    @Test
    public void ShouldSayWelcome(){
        store.welcome();

        verify(this.printStream).println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
    }

    @Test
    public void GetNotifiedWhenSubmittingWrongOption() {

        store.checkAction("wrong action");

        verify(this.printStream).println("Please select a valid option!");
    }

    @Test
    public void QuitTheProgramAfterSubmittingQuit() {

        store.checkAction("quit");

        verify(this.printStream).println("Bye Bye");
    }

    @Test
    public void ListMenu_ShouldShowSomeMenus_WhenThereIsNoLogIn(){
        String expected = "2 : This does not required log in\n" +
                "3 : This also does not required log in\n";

        store.listMenu();

        verify(this.printStream).println(expected);
    }

    @Test
    public void ListMenu_ShouldAllMenus_WhenThereIsLoggedIn(){
        String expected = "1 : This required log in\n" +
                "2 : This does not required log in\n" +
                "3 : This also does not required log in\n";

        store.listMenu();

        verify(this.printStream).println(expected);
    }
}
