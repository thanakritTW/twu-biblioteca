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
    // mock
    private Map<String, MenuInterface> menus;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private MenuInterface menu1;
    private MenuInterface menu2;
    private MenuInterface menu3;
    private List<User> users;
    private User user;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);

        menus = new HashMap<>();

        users = new ArrayList<>();
        user = mock(User.class);
        users.add(user);

        Map<String, MenuInterface> menus = new HashMap<String, MenuInterface>();

        menu1 = mock(MenuInterface.class);
        menu2 = mock(MenuInterface.class);
        menu3 = mock(MenuInterface.class);

        when(menu1.getDescription()).thenReturn("This required log in");
        when(menu1.isLoggedInRequired()).thenReturn(true);
        when(menu2.getDescription()).thenReturn("This does not required log in");
        when(menu2.isLoggedInRequired()).thenReturn(false);
        when(menu3.getDescription()).thenReturn("This also does not required log in");
        when(menu3.isLoggedInRequired()).thenReturn(false);

        menus.put("1",menu1);
        menus.put("2",menu2);
        menus.put("3",menu3);

        store = new Store(menus, users, printStream, bufferedReader);
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
        String expected = "Please select one of the following tasks\n" +
                "2 : This does not required log in\n" +
                "3 : This also does not required log in\n";
        when(user.isLoggedIn()).thenReturn(false);

        store.listMenu();

        verify(this.printStream).println(expected);
    }

    @Test
    public void ListMenu_ShouldAllMenus_WhenThereIsLoggedIn(){
        String expected = "Please select one of the following tasks\n" +
                "1 : This required log in\n" +
                "2 : This does not required log in\n" +
                "3 : This also does not required log in\n";
        when(user.isLoggedIn()).thenReturn(true);

        store.listMenu();

        verify(this.printStream).println(expected);
    }
}
